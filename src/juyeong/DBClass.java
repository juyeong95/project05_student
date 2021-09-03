package juyeong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBClass {
		private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
		private String id ="g3";
		private String pwd ="1234";
		
		public DBClass() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public int saveData(String userId, String userName, int userAge, String userMajor) {
			String sql = "insert into newst1 values(?,?,?,?)";
			int result =0;
			try {
				Connection con = DriverManager.getConnection(url,id,pwd);
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
		
		public StudentDTO searchST(String id) {
			String sql = "select * from newst1 where id = '"+id+"'";
			StudentDTO dto = null;
			try {
				Connection con = DriverManager.getConnection(url,this.id,pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					dto = new StudentDTO();
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setAge(rs.getInt("age"));
					dto.setMajor(rs.getString("major"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dto;
		}
		
}
