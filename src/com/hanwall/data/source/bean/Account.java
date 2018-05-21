package com.hanwall.data.source.bean;

public class Account {
	enum IDType{
		EBANK,
		GOVEMENT,
		EMAIL,
		COMMON
	};
	
	public int id;
	public String sysid;
	public String username;
	public String passwd;
	public String phone;
	public String identify;
	public String link;
	public String keywordid;
	public IDType idtype;
}

