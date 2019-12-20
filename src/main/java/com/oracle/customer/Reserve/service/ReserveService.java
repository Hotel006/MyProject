package com.oracle.customer.Reserve.service;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oracle.customer.Reserve.dao.ReserveDao;
import com.oracle.entity.Hotel_room;

public class ReserveService {
	
	ReserveDao rd = new ReserveDao();
	
	public Hotel_room roomByNumber(String room) throws SQLException {	
		Hotel_room hr = rd.queryRoomNumber(room);
		return hr;
	}
	
	public Map<Hotel_room, Integer> queryRoomsAll() throws SQLException{
		Hotel_room hr = new Hotel_room();
		List<Hotel_room> rlist = new ArrayList<Hotel_room>();
		List<Integer> nlist = new ArrayList<Integer>();
		Map<Hotel_room,Integer> map = new HashMap<Hotel_room,Integer>();
		List<Map<String, Object>> lm = rd.queryRoomsAll();	
		Map<String, Object> rmap = lm.get(0);
		Map<String, Object> nmap = lm.get(1);
		for (String key : nmap.keySet()) {
			nlist.add(Integer.parseInt(nmap.get(key).toString()));
		}
		for (String key : rmap.keySet()) {
			String room =  rmap.get(key).toString();
			hr = this.roomByNumber(room);
			rlist.add(hr);	
		}
		for (int i = 0; i < rlist.size(); i++) {
			map.put(rlist.get(i), nlist.get(i));	
		}
		return map;
	}
	
	public void indent() throws SQLException {
		rd.indent();
	}
}
