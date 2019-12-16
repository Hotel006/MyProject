package com.oracle.entity;

public class Hotel_admin{
	//属性列表
	private	int	aid;
	private	String	aloginname;
	private	String	aloginpass;
	private	String	anickname;
	private	java.util.Date	alasttime;
	//setter
	public void setAid(int aid){
		this.aid = aid;
	}
	//getter
	public int getAid(){
		 return aid;
	}
	//setter
	public void setAloginname(String aloginname){
		this.aloginname = aloginname;
	}
	//getter
	public String getAloginname(){
		 return aloginname;
	}
	//setter
	public void setAloginpass(String aloginpass){
		this.aloginpass = aloginpass;
	}
	//getter
	public String getAloginpass(){
		 return aloginpass;
	}
	//setter
	public void setAnickname(String anickname){
		this.anickname = anickname;
	}
	//getter
	public String getAnickname(){
		 return anickname;
	}
	//setter
	public void setAlasttime(java.util.Date alasttime){
		this.alasttime = alasttime;
	}
	//getter
	public java.util.Date getAlasttime(){
		 return alasttime;
	}
}
