package com.oracle.shop.check.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_room;
import com.oracle.shop.check.dao.ShowRoomDao;

public class ShowRoomService {
	public List<Hotel_room> showroom() throws SQLException{
		return new ShowRoomDao().showroom();
	}

}
