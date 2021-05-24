package me.qinyang.drp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbUtil {
	public static Connection getConnection(){
		Connection conn = null;
		try {
			JdbcConfig config = XmlConfigReader.getInstance().getConfig();
			Class.forName(config.getDriverName());
			conn = DriverManager.getConnection(config.getUrl(),config.getUserName(),config.getPassword());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;
	}
	
	public static void close(Connection conn){
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement pstmt){
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(DbUtil.getConnection());
	}
}
