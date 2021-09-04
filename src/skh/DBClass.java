package skh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DBClass {
	
	private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
	//private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String id = "g3";
	private String pwd = "1234";
	
	public DBClass() {
		try {
		// 1.자바에서 오라클에 관련된 기능을 사용할 수 있게 기능을 등록하는것
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Student> MemberView() {
		ArrayList<Student> arr = new ArrayList<Student>();
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			System.out.println("연결에 성공했습니다.");
			String sql = "select * from newst1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student st = new Student();
				st.setAge(rs.getInt("AGE"));
				st.setId(rs.getString("ID"));
				st.setName(rs.getString("NAME"));
				st.setMajor(rs.getString("MAJOR"));
				
				arr.add(st);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arr;
		
		
		
		
		
	}
	
	public int MemberAdd(String id, String name, int age, String major) {
		
		
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url,this.id,pwd);
			System.out.println("연결에 성공했습니다.");
			String sql = "insert into newst1 values(? , ? , ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, major);
			
			result = ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int Rename(String name, int age, String major, String id) {
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url,this.id,pwd);
			String sql = "update newst1 set name= ? ,age=? , major=? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, major);
			ps.setString(4, id);
			
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int Delete(String id) {
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url,this.id,pwd);
			String sql = "delete from newst1 where id = '"+id+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
