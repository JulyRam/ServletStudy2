package com.epic.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectot {

	public Connection getConnect() {
		String user = "USER02";
		String passward = "USER02";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, passward);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void disConnect(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
