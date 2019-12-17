package com.oracle.shop.room.service;

import java.sql.SQLException;

import com.oracle.entity.Hotel_room;
import com.oracle.shop.room.dao.AddRoomDao;

public class AddRoomService {
	public void add (String number) throws SQLException {
		
		Hotel_room hr = new Hotel_room();
		AddRoomDao ad = new AddRoomDao();
		hr = ad.queryByNumber(number);
		if (hr != null) {
			throw new RuntimeException("该房间已存在，请从新输入");
		}
	}
}
