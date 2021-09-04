package Jinwon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBClass {
	private String url = "jdbc:oracle:thin:@210.221.253.215:1521/xe";
	private String id = "g3";
	private String pwd = "1234";
	
	public DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<StudentDTO> getList() {
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결이 잘 이뤄졌습니다!!");
			String sql = "select * from newst";
			PreparedStatement ps = con.prepareStatement(sql);
	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setId( rs.getString("id") );
				dto.setName( rs.getString("name") );
				dto.setAge( rs.getInt("age") );
				dto.setMajor(rs.getString("major"));
				list.add(dto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public StudentDTO searchST(String id) {
	
		String sql = "select * from newst1 where id = '" + id + "'";
		StudentDTO dto = null;
		try {

			Connection con = DriverManager.getConnection(url, this.id, pwd);
			System.out.println("--- 연결 확인 ---");
		
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new StudentDTO();
				dto.setId( rs.getString("id") );
				dto.setName( rs.getString("name") );
				dto.setAge( rs.getInt("age") );
				dto.setMajor( rs.getString("major") );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int saveData(String userId, String userName,String userMajor, int userAge) {
		
		String sql = "insert into newst1 values(? , ? , ?)";
		int result = 0;
		try {
		
			Connection con = DriverManager.getConnection(url, id, pwd);
		
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, userId);
			ps.setString(2, userName);
			ps.setInt(3, userAge);
			ps.setString(4, userMajor);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int updateData(StudentDTO userId, String name, String major, int age) {
		int result = 0;
		//update newst set name='길이다',age=30 where id='111';
		String sql = "update newst set name= ? ,age=? where id = ? ";
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);
		
			ps.setString(3, userId);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(4, major);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null ) ps.close();
				if(con != null) con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public int deleteData(String userId) {
		int result=0;
		// delete from newst where id='aaa';
		String sql = "delete from newst where id='"+userId+"'";
		//String sql = "delete from newst where id=?";
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setString(1, userId); //  sql ?쿼리문일때 사용
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
