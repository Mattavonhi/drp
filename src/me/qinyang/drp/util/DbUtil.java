package me.qinyang.drp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dom4j.DocumentException;

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
	
	public static void main(String[] args) {
		System.out.println(DbUtil.getConnection());
	}
}
