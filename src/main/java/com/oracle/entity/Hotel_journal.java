package com.oracle.entity;

public class Hotel_journal{
	//属性列表
	private	int	jid;
	private	String	jname;
	private	String	jevent;
	private	String	jtime;
	//setter
	public void setJid(int jid){
		this.jid = jid;
	}
	//getter
	public int getJid(){
		 return jid;
	}
	//setter
	public void setJname(String jname){
		this.jname = jname;
	}
	//getter
	public String getJname(){
		 return jname;
	}
	//setter
	public void setJevent(String jevent){
		this.jevent = jevent;
	}
	//getter
	public String getJevent(){
		 return jevent;
	}
	//setter
	public void setJtime(String jtime){
		this.jtime = jtime;
	}
	//getter
	public String getJtime(){
		 return jtime;
	}
}
