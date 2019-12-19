package com.oracle.shop.room.service;

import java.sql.SQLException;

import com.oracle.entity.Hotel_room;
import com.oracle.shop.room.dao.AddRoomDao;
import com.oracle.shop.room.dao.Hotel_roomDao;

public class AddRoomService {
	public void add (Hotel_room hr ) throws SQLException {
		
		String number = hr.getRnumber();
		AddRoomDao ad = new AddRoomDao();
		Hotel_room qbn = ad.queryByNumber(number);
		if (qbn == null) {
			/* throw new RuntimeException("该房间已存在，请从新输入"); */
			ad.save(hr);
		}
		
	}

	
}
