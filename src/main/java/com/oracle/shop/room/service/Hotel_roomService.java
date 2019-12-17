package com.oracle.shop.room.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_room;
import com.oracle.shop.room.dao.Hotel_roomDao;


public class Hotel_roomService {
	
	Hotel_roomDao hte = new Hotel_roomDao();
	/*
	 * public Hotel_room queryById( int rid) throws SQLException { return
	 * hte.queryById(rid); }
	 */
	
	public List<Hotel_room> queryAll() throws SQLException {
		List<Hotel_room> hr = hte.queryAll();
		
		System.out.println(hr.size());
		return hr;
	}

	
}
