package com.oracle.customer.Reserve.service;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.List;

import com.oracle.customer.Reserve.dao.ReserveDao;
import com.oracle.entity.Hotel_room;

public class ReserveService {
	
	ReserveDao rd = new ReserveDao();
	
	public List<Hotel_room> allRoom() throws SQLException {
		
		List<Hotel_room> hr = rd.queryAllRooms();
		return hr;
	}
	
	public void indent() throws SQLException {
		rd.indent();
	}
}
