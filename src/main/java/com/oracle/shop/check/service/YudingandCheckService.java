package com.oracle.shop.check.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_order;
import com.oracle.shop.check.dao.CheckDao;
import com.oracle.shop.check.dao.QueryDao;
import com.oracle.shop.check.dao.YudingDao;
import com.oracle.util.DateUtil;

public class YudingandCheckService {
	YudingDao ydao =new YudingDao(); 
	public List<Hotel_order> showroom(String room) throws SQLException{
		List<Hotel_order> list= ydao.showroom(room);
		return list;
	}
	public List<Hotel_order> showcheck(String room) throws SQLException{
		return new YudingDao().showcheck(room);
	}
	QueryDao qDao =new QueryDao();
	public void yuding(String name, String cardid, String phone, String day, String money) throws SQLException {
		List<Hotel_order> list=qDao.queryruzhu();
		CheckDao cDao =new CheckDao();
		boolean flag=true;
		for (Hotel_order h : list) {
			if (h.getOcard().equals(cardid)) {
				flag=false;
				throw new RuntimeException("身份证号重复，无法入住");
			}
		}
		if(flag==true) {
			long onumber =System.currentTimeMillis();
			int oday=Integer.valueOf(day);
			int totlemoney=oday*Integer.valueOf(money);
			String outtime=DateUtil.nexttime(oday);
			System.out.println(totlemoney);
			String nowtime=DateUtil.nowtime(DateUtil.H);
			cDao.ydcheck(onumber,name,phone,totlemoney,oday,nowtime,outtime,cardid);
		}
	}
	public void ruzhu(String name, String cardid, String phone, String day, String money, String room) throws SQLException {
		List<Hotel_order> list=qDao.queryruzhu();
		CheckDao cDao =new CheckDao();
		boolean flag=true;
		for (Hotel_order h : list) {
			if (h.getOcard().equals(cardid)) {
				flag=false;
				throw new RuntimeException("身份证号重复，无法入住");
			}
		}
		if(flag==true) {
			long onumber =System.currentTimeMillis();
			int oday=Integer.valueOf(day);
			int totlemoney=oday*Integer.valueOf(money);
			String outtime=DateUtil.nexttime(oday);
			System.out.println(totlemoney);
			String nowtime=DateUtil.nowtime(DateUtil.H);
			String type=room.split("/")[1];
			String oroom=room.split("/")[0];
			cDao.check(onumber,name,phone,totlemoney,oroom,type,oday,nowtime,outtime,cardid);
		}
	}
	
	public void  reserve(String name, String phone, String day, String money, String room, String souce, String time) throws SQLException {
		CheckDao cDao =new CheckDao();
		long onumber =System.currentTimeMillis();
		int oday=Integer.valueOf(day);
		int totlemoney=oday*Integer.valueOf(money);
		String outtime=DateUtil.nexttime(oday);
		String type=room.split("/")[1];
		String oroom=room.split("/")[0];
		String nowtime=DateUtil.nowtime(DateUtil.H);
		String wday=nowtime.substring(8, 10);
		int yjday=Integer.valueOf(time.split("-")[1])-Integer.valueOf(wday);
		String yjcometime=DateUtil.nexttime(yjday);
		String yjouttime =DateUtil.nexttime(yjday+oday);
		cDao.yuding(onumber,name,phone,oroom,type,totlemoney,oday,yjcometime,yjouttime,souce);
	}
	
	public void removeyuding(String room) throws SQLException {
		ydao.removeyuding(room);
	}

}
