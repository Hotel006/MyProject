package com.oracle.entity;

public class Hotel_order{
	//属性列表
	private	int	oid;
	private	String	onumber;
	private	String	oname;
	private	String	ophone;
	private	String	ohouse;
	private	String	ocount;
	private	String	omoney;
	private String  oroom;
	private String  rmoney;
	private	java.util.Date	oontime;
	private	java.util.Date	oydontime;
	private	java.util.Date	oouttime;
	private	String	ooderstate;
	private	String	osource;
	private	String	ocard;
	private	String	oday;
	private String oyjouttime;
	
	
	public String getOyjouttime() {
		return oyjouttime;
	}
	public void setOyjouttime(String oyjouttime) {
		this.oyjouttime = oyjouttime;
	}
	public String getRmoney() {
		return rmoney;
	}
	public void setRmoney(String rmoney) {
		this.rmoney = rmoney;
	}
	public String getOday() {
		return oday;
	}
	public void setOday(String oday) {
		this.oday = oday;
	}
	public java.util.Date getOydontime() {
		return oydontime;
	}
	public void setOydontime(java.util.Date oydontime) {
		this.oydontime = oydontime;
	}
	public String getOroom() {
		return oroom;
	}
	public void setOroom(String oroom) {
		this.oroom = oroom;
	}
	//setter
	public void setOid(int oid){
		this.oid = oid;
	}
	//getter
	public int getOid(){
		 return oid;
	}
	//setter
	public void setOnumber(String onumber){
		this.onumber = onumber;
	}
	//getter
	public String getOnumber(){
		 return onumber;
	}
	//setter
	
	//setter
	public void setOphone(String ophone){
		this.ophone = ophone;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	//getter
	public String getOphone(){
		 return ophone;
	}
	//setter
	public void setOhouse(String ohouse){
		this.ohouse = ohouse;
	}
	//getter
	public String getOhouse(){
		 return ohouse;
	}
	//setter
	public void setOcount(String ocount){
		this.ocount = ocount;
	}
	//getter
	public String getOcount(){
		 return ocount;
	}
	//setter
	public void setOmoney(String omoney){
		this.omoney = omoney;
	}
	//getter
	public String getOmoney(){
		 return omoney;
	}
	//setter
	public void setOontime(java.util.Date oontime){
		this.oontime = oontime;
	}
	//getter
	public java.util.Date getOontime(){
		 return oontime;
	}
	//setter
	public void setOouttime(java.util.Date oouttime){
		this.oouttime = oouttime;
	}
	//getter
	public java.util.Date getOouttime(){
		 return oouttime;
	}
	//setter
	public void setOoderstate(String ooderstate){
		this.ooderstate = ooderstate;
	}
	//getter
	public String getOoderstate(){
		 return ooderstate;
	}
	//setter
	public void setOsource(String osource){
		this.osource = osource;
	}
	//getter
	public String getOsource(){
		 return osource;
	}
	//setter
	public void setOcard(String ocard){
		this.ocard = ocard;
	}
	//getter
	public String getOcard(){
		 return ocard;
	}
}
