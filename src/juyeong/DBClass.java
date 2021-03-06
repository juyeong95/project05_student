package juyeong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBClass {
		private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
		private String id ="g3";
		private String pwd ="1234";
		private String sql=null;
		private int result =0;
		Connection con;
		PreparedStatement ps;
		
		public DBClass() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void Connection() {
			try {
				con=DriverManager.getConnection(url,id,pwd);
				ps=con.prepareStatement(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public int saveData(String userId, String userName, int userAge, String userMajor) {
			sql = "insert into newst1 values(?,?,?,?)";
			result =0;
			try {
				Connection();
				
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
			sql = "select * from newst1 where id = '"+id+"'";
			StudentDTO dto = null;
			try {
				Connection();
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
		public ArrayList<StudentDTO> getList() {
			ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
			try {
				sql = "select * from newst1";
				Connection();
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					StudentDTO dto = new StudentDTO();
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setAge(rs.getInt("age"));
					dto.setMajor(rs.getString("major"));
					
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		public int update(String userId, String userName, int userAge, String userMajor) {
			result=0;
			sql = "update newst1 set name =?, age=?, major=? where id =?";
			try {
				Connection();
				
				ps.setString(1,userName);
				ps.setInt(2, userAge);
				ps.setString(3, userMajor);
				ps.setString(4, userId);
				
				result = ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		public int delete(String userId) {
			result = 0;
			sql = "delete from newst1 where id='"+userId+"'";
			try {
				Connection();
				
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
}
