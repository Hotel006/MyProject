package com.oracle.shop.room.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_order;
import com.oracle.entity.Hotel_room;
import com.oracle.shop.room.dao.BaobiaoDao;

public class BaobiaoService {

BaobiaoDao hte = new BaobiaoDao();
	
	//查询全部
	public List<Hotel_order> queryAll() throws SQLException {
		List<Hotel_order> hr = hte.queryAll();
		
		System.out.println(hr.size());
		return hr;
	}
	//通过年份查
	public List<Hotel_order> queryYear(String year) throws SQLException {
		List<Hotel_order> hr = hte.queryYear(year);
		System.out.println(hr.size());
		return hr;
	}

	//通过月份查
		public List<Hotel_order> queryMonth(String month) throws SQLException {
			List<Hotel_order> hr = hte.queryMonth(month);
			System.out.println(hr.size());
			return hr;
		}
}
