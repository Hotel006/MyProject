package com.oracle.customer.Reserve.service;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.oracle.customer.Reserve.dao.ReserveDao;
import com.oracle.entity.Hotel_room;

public class ReserveService {
	
	ReserveDao rd = new ReserveDao();
	
	public List<Hotel_room> roomByNumber() throws SQLException {	
		List<Hotel_room> hr = rd.queryAllRooms();
		return hr;
	}
	
	public List<Map<String, Object>> queryRoomsNumber() throws SQLException{
		List<Map<String, Object>> lm = rd.queryRoomsNumber();
		return lm;
	}
	
	public void indent() throws SQLException {
		rd.indent();
	}
}
