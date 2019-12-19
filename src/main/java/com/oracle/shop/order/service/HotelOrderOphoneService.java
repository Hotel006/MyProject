package com.oracle.shop.order.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_order;
import com.oracle.shop.order.dao.HotelOrderDao;

public class HotelOrderOphoneService {
	
	
public List<Hotel_order> queryByOphone(String ophone) throws SQLException {
	
	HotelOrderDao hl = new HotelOrderDao();
		
	return hl.queryByOphone(ophone);
		
	}

}
