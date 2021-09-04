package seoon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class seoon_controller {
	seoon_DBClass sc = new seoon_DBClass();
	
	//리스트에 불러오기
	public ArrayList<seoon_StDTO> getList(){
		ArrayList<seoon_StDTO> list = new ArrayList<seoon_StDTO>();
		try {
			Connection conn = DriverManager.getConnection(sc.getUrl(), sc.getId(), sc.getPwd());
			System.out.println("Connected");
			String sql = "select * from newst1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				seoon_StDTO dto = new seoon_StDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setMajor(rs.getString("major"));
				dto.setAge(rs.getInt("age"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//검색하기
	public seoon_StDTO search(String id) {
		String sql =  "select * from newst1 where id = '" + id + "'";
		seoon_StDTO dto = null;
		
		try {
			Connection conn = DriverManager.getConnection(sc.getUrl(),this.sc.getId(),sc.getPwd());
			System.out.println("check connect");
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				dto = new seoon_StDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setMajor(rs.getString("major"));
				dto.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	
	//저장하기
	public int saveData(String userId, String userName, String userMajor, int userAge) {
		String sql = "insert into newst1 values(?, ?, ? ,?)";
		int result = 0;

		try {
			Connection conn = DriverManager.getConnection(sc.getUrl(),this.sc.getId(),sc.getPwd());
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userName);
			ps.setString(3, userMajor);
			ps.setInt(4, userAge);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//삭제하기
	public int deleteDataString (String userId){
		int result = 0;
		String sql = "delete from newst1 where id='"+ userId +"'";
		try {
			Connection conn = DriverManager.getConnection(sc.getUrl(),this.sc.getId(),sc.getPwd());
			PreparedStatement ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//수정
	public int updateData(String userId, String name, String major, int age) {
		int result = 0;
		String sql = "update newst1 set name= ? ,major= ?, age= ? where id= ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(sc.getUrl(), sc.getId(), sc.getPwd());
			ps = conn.prepareStatement(sql);
			
			ps.setString(4, userId);
			ps.setString(1, name);
			ps.setString(2, major);
			ps.setInt(3, age);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)	ps.close();
				if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}
}
