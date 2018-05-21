package com.hanwall.data.source.bean;

public class Keyword {
	enum KeyType{
		USERNAME,
		PASSWD,
		PHONE,
		ID
	};
	
	public int keyid;
	public KeyType	keytype;
	public String keyword;
}
