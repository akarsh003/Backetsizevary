package com.example.demo;

import java.util.List;

public class WorkObject {

	
	private String user;
	private String WorkRequestType;
	private String Wrokrequests;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
	
	public WorkObject(String userr,String workRequestType, String wrokrequests) {
//		super();
		user=userr;
		WorkRequestType = workRequestType;
		Wrokrequests = wrokrequests;
	}
	
	public String getWorkRequestType() {
		return WorkRequestType;
	}
	public void setWorkRequestType(String workRequestType) {
		WorkRequestType = workRequestType;
	}
	public String getWrokrequests() {
		return Wrokrequests;
	}
	public void setWrokrequests(String wrokrequests) {
		Wrokrequests = wrokrequests;
	}
	
	
	
}
