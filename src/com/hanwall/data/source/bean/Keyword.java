package com.hanwall.data.source.bean;

public class Keyword {
	enum KeyType{
		USERNAME,
		PASSWD,
		PHONE,
		ID
		
	};
	
	public int id;
	public KeyType	keytype;
	public String keyword;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public KeyType getKeytype() {
		return keytype;
	}
	public void setKeytype(KeyType keytype) {
		this.keytype = keytype;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
