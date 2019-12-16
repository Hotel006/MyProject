package com.oracle.customer.LoginAndReg.entity;

import java.util.Date;

public class Admin {
	private int aid;
	private String aloginname;
	private String aloginpass;
	private String anikename;
	private Date alasttime;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAloginname() {
		return aloginname;
	}
	public void setAloginname(String aloginname) {
		this.aloginname = aloginname;
	}
	public String getAloginpass() {
		return aloginpass;
	}
	public void setAloginpass(String aloginpass) {
		this.aloginpass = aloginpass;
	}
	public String getAnikename() {
		return anikename;
	}
	public void setAnikename(String anikename) {
		this.anikename = anikename;
	}
	public Date getAlasttime() {
		return alasttime;
	}
	public void setAlasttime(Date alasttime) {
		this.alasttime = alasttime;
	}
	
	
}
