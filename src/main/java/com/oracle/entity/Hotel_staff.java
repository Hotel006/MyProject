package com.oracle.entity;

import java.util.Date;

public class Hotel_staff{
	//属性列表
	private	int	sid;
	private	String	sname;
	private	String	ssex;
	private	int	sage;
	private	Date	sbirthday;
	private	String	sphone;
	private	String	sentername;
	private	String	senterpass;
	//setter
	public void setSid(int sid){
		this.sid = sid;
	}
	//getter
	public int getSid(){
		 return sid;
	}
	//setter
	public void setSname(String sname){
		this.sname = sname;
	}
	//getter
	public Object getSname(){
		 return sname;
	}
	//setter
	public void setSsex(String ssex){
		this.ssex = ssex;
	}
	//getter
	public Object getSsex(){
		 return ssex;
	}
	//setter
	public void setSage(int sage){
		this.sage = sage;
	}
	//getter
	public Object getSage(){
		 return sage;
	}
	//setter
	public void setSbirthday(Date sbirthday){
		this.sbirthday = sbirthday;
	}
	//getter
	public Object getSbirthday(){
		 return sbirthday;
	}
	//setter
	public void setSphone(String sphone){
		this.sphone = sphone;
	}
	//getter
	public Object getSphone(){
		 return sphone;
	}
	//setter
	public void setSentername(String sentername){
		this.sentername = sentername;
	}
	//getter
	public Object getSentername(){
		 return sentername;
	}
	//setter
	public void setSenterpass(String senterpass){
		this.senterpass = senterpass;
	}
	//getter
	public Object getSenterpass(){
		 return senterpass;
	}

}
