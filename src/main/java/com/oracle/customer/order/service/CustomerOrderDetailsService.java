package com.oracle.customer.order.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.customer.order.dao.CustomerOrderDao;
import com.oracle.entity.Hotel_order;

public class CustomerOrderDetailsService {
	
	CustomerOrderDao cod = new CustomerOrderDao();
	
	public List<Hotel_order> queryByDetails()  throws SQLException{
		
		List<Hotel_order> list = cod.queryByDetails();
		System.out.println(list.size());
		return list;
		
	}

}
