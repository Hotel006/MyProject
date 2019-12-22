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
			oDao.out(hnumber,hpeople,hphone,hhouse,hcount,hmoney,hontime,houttime,hsource,hcard);
		}
	}
	}
	public void clean(String room,String text) throws SQLException {
		int day = 0 ;
		if(text==null) {
			oDao.clean(room);
		}else {
			List<Hotel_order> list =new QueryDao().queryruzhu();
			for (Hotel_order h : list) {
				if(h.getOroom().equals(room)) {
					day =Integer.valueOf(h.getOday())+Integer.valueOf(text);
				}
			}
			oDao.xuzhu(room,day);
		}
		
	}

}
