package com.oracle.entity;

public class Hotel_room{
	//属性列表
	private	int	rid;
	private int rstatus;
	private	String	rhouse;
	private	String	rmoney;
	private	String	rcount;
	private	String	rimg;
	private	String	rnumber;
	
	//setter
	public void setRid(int rid){
		this.rid = rid;
	}
	//getter
	public int getRid(){
		 return rid;
	}
	//setter
	public void setRhouse(String rhouse){
		this.rhouse = rhouse;
	}
	//getter
	public String getRhouse(){
		 return rhouse;
	}
	//setter
	public void setRmoney(String rmoney){
		this.rmoney = rmoney;
	}
	//getter
	public String getRmoney(){
		 return rmoney;
	}
	//setter
	public void setRcount(String rcount){
		this.rcount = rcount;
	}
	//getter
	public String getRcount(){
		 return rcount;
	}
	//setter
	public void setRimg(String rimg){
		this.rimg = rimg;
	}
	//getter
	public String getRimg(){
		 return rimg;
	}
	//setter
	public void setRnumber(String rnumber){
		this.rnumber = rnumber;
	}
	//getter
	public String getRnumber(){
		 return rnumber;
	}
	public int getRstatus() {
		return rstatus;
	}
	public void setRstatus(int rstatus) {
		this.rstatus = rstatus;
	}
}
