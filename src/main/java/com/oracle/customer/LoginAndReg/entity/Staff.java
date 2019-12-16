package com.oracle.customer.LoginAndReg.entity;

import java.util.Date;

public class Staff {
	
	private int sid;
	private String sname;
	private String ssex;
	private int sage;
	private Date sbirthday;
	private String sphone;
	private String sentername;
	private String senterpass;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public Date getSbirthday() {
		return sbirthday;
	}
	public void setSbirthday(Date sbirthday) {
		this.sbirthday = sbirthday;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSentername() {
		return sentername;
	}
	public void setSentername(String sentername) {
		this.sentername = sentername;
	}
	public String getSenterpass() {
		return senterpass;
	}
	public void setSenterpass(String senterpass) {
		this.senterpass = senterpass;
	}
	
	
}
