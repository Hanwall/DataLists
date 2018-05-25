package com.hanwall.data.source.bean;

public class Account {
	public enum IDType{
		EBANK, 
		GOVEMENT,
		EMAIL,
		QQ,
		COMMON;
		public static IDType setIDType(int index) {
			for(IDType i : IDType.values()) {
				if (index == i.ordinal()) {
					return i;
				}
			}
			return null;
			
		}
		
	};
	
	public int id;
	public String sysid;
	public String username;
	public String email;
	public String passwd;
	public String phoneNum;
	public String identify; 
	public String link; 
	public String keywordid; 
	public IDType idtype; 
	public String status;
	public String evidence;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSysid() {
		return sysid;
	}
	public void setSysid(String sysid) {
		this.sysid = sysid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getKeywordid() {
		return keywordid;
	}
	public void setKeywordid(String keywordid) {
		this.keywordid = keywordid;
	}
	public IDType getIdtype() {
		return idtype;
	}
	public void setIdtype(IDType idtype) {
		this.idtype = idtype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEvidence() {
		return evidence;
	}
	public void setEvidence(String evidence) {
		this.evidence = evidence;
	} 
	
	
}

