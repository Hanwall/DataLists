package com.hanwall.data.source.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hanwall.data.source.bean.Account;
import com.hanwall.data.source.bean.Account.IDType;

public class QueryData {
	public static QueryData query() {
		Connection conn = ConnectDatabase.getConn();
	    String sql = "select * from account";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        while (rs.next()) {
	        	for (int i = 1; i+10 <= col; i++) {
	            	Account ac = new Account();
	            	ac.setId(rs.getInt(i));
	            	ac.setSysid(rs.getString(i+1));
	            	ac.setUsername(rs.getString(i+2));
	            	ac.setEmail(rs.getString(i+3));
	            	ac.setPasswd(rs.getString(i+4));
	            	ac.setPhoneNum(rs.getString(i+5));
	            	ac.setIdentify(rs.getString(i+6));
	            	ac.setLink(rs.getString(i+7));
	            	ac.setIdtype(IDType.setIDType(rs.getInt(i+8)));
	            	ac.setStatus(rs.getString(i+9));
	            	ac.setEvidence(rs.getString(i+10));
	               }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    try {
	    	
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return null;
	}
}
