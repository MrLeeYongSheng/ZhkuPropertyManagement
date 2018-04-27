package com.lys.zhku.utils;

public enum Authorities {

	admin("admin"),
	user("user"),
	worker("worker");
	
	Authorities(String auth) {
		this.auth=auth;
	}
	
	private String auth;
		
	public String getAuth() {
		return this.auth;
	}
}
