package com.hanwall.data.source.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hanwall.data.source.bean.Account;
import com.hanwall.data.source.bean.Account.IDType;

public class QueryData {
	
	public static List<Account> query() {
		Connection conn = ConnectDatabase.getConn();
	    String sql = "select * from account";
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Account> list = new ArrayList<Account>();  
	    try {
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	       
	        while (rs.next()) {
	        		Account ac = new Account();
	            	ac.setId(rs.getInt("id"));
	            	ac.setSysid(rs.getString("sysid"));
	            	ac.setUsername(rs.getString("username"));
	            	ac.setEmail(rs.getString("email"));
	            	ac.setPasswd(rs.getString("passwd"));
	            	ac.setPhoneNum(rs.getString("phoneNum"));
	            	ac.setIdentify(rs.getString("identify"));
	            	ac.setLink(rs.getString("link"));
	            	ac.setKeywordid(rs.getString("keywordid"));
	            	ac.setIdtype(IDType.setIDType(rs.getInt("idtype")));
	            	ac.setStatus(rs.getString("status"));
	            	ac.setEvidence(rs.getString("evidence"));
	                list.add(ac);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    
	    	try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
		
	    
	    return list;
	}
}
