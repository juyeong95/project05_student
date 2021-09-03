package jihee;

import java.sql.Connection;
import java.sql.DriverManager;


public class Ji_DBClass {
	private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
	private String id = "g3";
	private String pwd = "1234";
	Ji_DBClass(){
		
		try {
			Class.forName("orcle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getList() {
		
		try {
		Connection con = DriverManager.getConnection(url,id,pwd);
		System.out.println("연결이 잘 이뤄졌습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
