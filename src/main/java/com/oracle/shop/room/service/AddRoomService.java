package com.oracle.shop.room.service;

import java.sql.SQLException;

import com.oracle.entity.Hotel_room;
import com.oracle.shop.room.dao.AddRoomDao;
import com.oracle.shop.room.dao.Hotel_roomDao;

public class AddRoomService {
	
	public void add (Hotel_room hr ) throws SQLException {
		
		AddRoomDao ad = new AddRoomDao();
		
		ad.save(hr);
	}
}
