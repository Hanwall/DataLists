package com.hanwall.data.source.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryData {
	public static QueryData query() {
		Connection conn = Connect.getConn();
	    String sql = "select * from account";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("start============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\n");
	              }
	        }
	        System.out.println("end==============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}
