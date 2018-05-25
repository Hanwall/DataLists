package com.hanwall.data.source.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hanwall.data.utils.Config;

public class ConnectDatabase {
	public static Connection getConn() {
		Connection conn = null;
	    try {
	        Class.forName(Config.driver); 
	        conn = (Connection) DriverManager.getConnection(Config.url, Config.username, Config.password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
}
