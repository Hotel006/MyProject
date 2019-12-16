package com.oracle.entity;

public class User_admin{
	//属性列表
	private	int	uid;
	private	Object	uloginname;
	private	Object	uloginpass;
	private	Object	unickname;
	//setter
	public void setUid(int uid){
		this.uid = uid;
	}
	//getter
	public int getUid(){
		 return uid;
	}
	//setter
	public void setUloginname(Object uloginname){
		this.uloginname = uloginname;
	}
	//getter
	public Object getUloginname(){
		 return uloginname;
	}
	//setter
	public void setUloginpass(Object uloginpass){
		this.uloginpass = uloginpass;
	}
	//getter
	public Object getUloginpass(){
		 return uloginpass;
	}
	//setter
	public void setUnickname(Object unickname){
		this.unickname = unickname;
	}
	//getter
	public Object getUnickname(){
		 return unickname;
	}
}
