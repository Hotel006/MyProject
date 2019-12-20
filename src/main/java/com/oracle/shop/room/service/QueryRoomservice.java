package com.oracle.shop.room.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_room;
import com.oracle.shop.room.dao.QueryRoom;

public class QueryRoomservice {
	QueryRoom qr =new QueryRoom();
	public List<Hotel_room> queryallroom() throws SQLException{
		return qr.queryallroom();
	}

}
