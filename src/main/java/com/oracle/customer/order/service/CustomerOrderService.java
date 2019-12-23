package com.oracle.customer.order.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.customer.order.dao.CustomerOrderDao;
import com.oracle.entity.Hotel_order;

public class CustomerOrderService {
	
	CustomerOrderDao cod = new CustomerOrderDao();

	public List<Hotel_order> queryByIntro(int uid) throws SQLException {
		List<Hotel_order> list = cod.queryByIntro(uid);
		System.out.println(list.size());
		return list;
	}

	

}
