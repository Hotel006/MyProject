package com.oracle.shop.order.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_order;
import com.oracle.shop.order.dao.HotelOrderDao;

public class HotelOrderOhouseService {
	
	HotelOrderDao hd = new HotelOrderDao();
	public List<Hotel_order> queryByOhouse(String ohouse) throws SQLException {
		
		return hd.queryByOhouse(ohouse);
		
	}

}
