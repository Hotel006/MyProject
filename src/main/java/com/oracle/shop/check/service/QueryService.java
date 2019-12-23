package com.oracle.shop.check.service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.oracle.entity.Hotel_order;
import com.oracle.shop.check.dao.QueryDao;
import com.oracle.util.DateUtil;

public class QueryService {
	QueryDao qDao =new QueryDao();
	public List<Hotel_order> queryyuding() throws Exception{
		return qDao.queryyuding();
	}
	public List<Hotel_order> queryruzhu() throws Exception{
		
		List<Hotel_order> list= qDao.queryruzhu();
		for (Hotel_order h : list) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String nowtime=DateUtil.nowtime(DateUtil.H);
			String q=DateUtil.datetostring(h.getOyjouttime(), DateUtil.H);
			 Date d1 = df.parse(nowtime);
			 Date d2 =df.parse(q);
			 int state =Integer.valueOf(h.getOoderstate());
	
			 long diff = d2.getTime() - d1.getTime();

			 long days = diff / (1000 * 60 * 60 * 24);  

		     long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);  
		     
		     long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60); 

		     if(state!=2&&days==0&&hours>=0&&hours<2) {
		    	 qDao.upmsdatestate(h.getOroom());
		     }
		     if(days<0||hours<0||minutes<0) {
		    	
		    	 qDao.updatestate(h.getOroom());
		     }
		}
		return list;
	}

}
