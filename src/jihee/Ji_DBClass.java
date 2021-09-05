package jihee;

import java.sql.*;
import java.util.ArrayList;

public class Ji_DBClass {
	
	
	private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
	private String id = "g3";
	private String pwd = "1234";
	String userId,userName,userMajor;
	int userAge;
	
	Ji_DBClass(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Ji_StudentDTO> getList() { //회원의 목록보기 기능담당
		ArrayList<Ji_StudentDTO> list = new ArrayList<>();
		
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			String sql = "select * from newst1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Ji_StudentDTO dt = new Ji_StudentDTO();
				dt.setId(rs.getString("id"));
				dt.setName(rs.getString("name"));
				dt.setMajor(rs.getString("major"));
				dt.setAge(rs.getInt("age"));
				
				list.add(dt);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public int MemberAdd(String userId, String userName,int userAge ,String userMajor) {  //회원의 목록을 추가하는 기능 담당
		String sql = "insert into newst1 values(? , ? , ? , ?)";
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userName);
			ps.setString(4, userMajor);
			ps.setInt(3, userAge);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Ji_StudentDTO searchST(String userId) {  //회원의 목록을 검색하는 기능 담당
		String sql = "select * from newst1 where id = '"+ userId +"'";
		Ji_StudentDTO dt = null;
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int Delete(String userId) {   //회원의 목록을 삭재하는 기능 담당
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			String sql = "delete from newst1 where id='"+ userId +"'";
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	public int Rename(String userName, int userAge, String userMajor, String userId) {
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url,this.id,pwd);
			String sql = "update newst1 set name= ?, age=?, major=? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, userName);
			ps.setInt(2, userAge);
			ps.setString(3, userMajor);
			ps.setString(4, userId);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
