package com.oracle.shop.order.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_order;
import com.oracle.shop.order.dao.HotelOrderDao;

public class HotelOrderService {
	HotelOrderDao hd = new HotelOrderDao();
	
	public List<Hotel_order> queryAll()  throws SQLException{
		List<Hotel_order> list = hd.queryAll();
		System.out.println(list.size());
		return list;
	}
}
