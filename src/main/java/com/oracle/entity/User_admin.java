package com.oracle.entity;

public class User_admin{
	//属性列表
	private	int	uid;
	private	String	uloginname;
	private	String	uloginpass;
	private	String	unickname;
	//setter
	public void setUid(int uid){
		this.uid = uid;
	}
	//getter
	public int getUid(){
		 return uid;
	}
	//setter
	public void setUloginname(String uloginname){
		this.uloginname = uloginname;
	}
	//getter
	public Object getUloginname(){
		 return uloginname;
	}
	//setter
	public void setUloginpass(String uloginpass){
		this.uloginpass = uloginpass;
	}
	//getter
	public Object getUloginpass(){
		 return uloginpass;
	}
	//setter
	public void setUnickname(String unickname){
		this.unickname = unickname;
	}
	//getter
	public Object getUnickname(){
		 return unickname;
	}
}
