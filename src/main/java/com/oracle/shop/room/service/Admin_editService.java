package com.oracle.shop.room.service;


import java.sql.SQLException;

import com.oracle.entity.Hotel_room;
import com.oracle.shop.room.dao.AddRoomDao;
import com.oracle.shop.room.dao.Admin_editDao;

public class Admin_editService {

	public void Alter (String rnumber,String rhouse,String rmoney) throws SQLException {
		
		Admin_editDao ad  = new Admin_editDao();
		ad.updateRoomByRnumber(rnumber,rhouse,rmoney);
	}
}
