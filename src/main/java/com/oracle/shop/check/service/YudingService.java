package com.oracle.shop.check.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_order;
import com.oracle.shop.check.dao.YudingDao;

public class YudingService {
	YudingDao ydao =new YudingDao(); 
	public List<Hotel_order> showroom(String room) throws SQLException{
		List<Hotel_order> list= ydao.showroom(room);
		return list;
	}
	public List<Hotel_order> showcheck(String room) throws SQLException{
		return new YudingDao().showcheck(room);
	}

}
