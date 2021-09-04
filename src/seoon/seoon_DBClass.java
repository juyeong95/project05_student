package seoon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class seoon_DBClass {
	private final String url = "jdbc:oracle:thin:@210.221.253.215:1521/xe";
	private final String id = "g3";
	private final String pwd = "1234";
	
	public String getUrl() {
		return url;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public seoon_DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
