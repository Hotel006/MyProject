package com.oracle.shop.order.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_order;
import com.oracle.shop.order.dao.HotelOrderDao;

public class HotelOrderOnumberService {
	
public List<Hotel_order> queryByOnumber(String onumber) throws SQLException {
	
	HotelOrderDao hr = new HotelOrderDao();
		
	return hr.queryByOnumber(onumber);
		
	}
	

}
