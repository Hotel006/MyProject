package com.oracle.shop.check.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.oracle.entity.Hotel_order;
import com.oracle.shop.check.dao.OutDao;
import com.oracle.shop.check.dao.QueryDao;
import com.oracle.util.DateUtil;

public class OutService {
	OutDao oDao= new OutDao();
	String hnumber;
	String hpeople;
	String hphone;
	String hhouse;
	String hcount;
	String hmoney;
	Date hontime;
	String houttime;
	String hsource;
	String hcard;
	QueryDao qDao = new QueryDao();
	public void out(String room) throws Exception {
	List<Hotel_order> list=qDao.queryruzhu();
	for (Hotel_order h : list) {
		if (h.getOroom().equals(room)) {
			hnumber=h.getOnumber();
			hpeople=h.getOname();
			hphone=h.getOphone();
			hhouse=h.getOhouse();
			hcount=h.getOroom();
			hmoney=h.getOmoney();
			hontime=h.getOontime();
			houttime=DateUtil.nowtime(DateUtil.H);
			hsource=h.getOsource();
			hcard=h.getOcard();
			System.out.println(hnumber);
			System.out.println(hpeople);
			System.out.println(hphone);
			System.out.println(hhouse);
			System.out.println(hcount);
			System.out.println(hmoney);
			System.out.println(hontime);
			System.out.println(houttime);
			System.out.println(hsource);
			System.out.println(hcard);
			oDao.out(hnumber,hpeople,hphone,hhouse,hcount,hmoney,hontime,houttime,hsource,hcard);
		}
	}
	}
	public void clean(String room,String text) throws SQLException {
		if(text==null) {
			oDao.clean(room);
		}else {
			oDao.xuzhu(room,text);
		}
		
	}

}
