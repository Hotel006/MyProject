package com.oracle.shop.order.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_order;
import com.oracle.shop.order.dao.HotelOrderDao;

public class HotelOrderOsourceService {
	
	
public List<Hotel_order> queryByOsource(String osource) throws SQLException {
		
		HotelOrderDao ho = new HotelOrderDao();
		return ho.queryByOsource(osource);
				
	}

}
