package com.oracle.shop.order.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_order;
import com.oracle.shop.order.dao.HotelOrderDao;

public class HotelOrderDeleteOnumberService {
	
public List<Hotel_order> queryDeleteOnumber(String onumber) throws SQLException {
		
	HotelOrderDao hod = new HotelOrderDao();
		
	return hod.queryDeleteOnumber(onumber);
		
	}

}
