package com.oracle.shop.room.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oracle.entity.Hotel_room;
import com.oracle.shop.room.dao.AmountRoomDao;

public class AmountRoomService {

	//======房间总数
	AmountRoomDao ee = new AmountRoomDao();
	
	public Object queryBySum() throws SQLException{
		return ee.queryBySum();
	}
	
	
	//=====类型总数
	
	public Object queryByType() throws SQLException {
		return ee.queryByType();
	}
	
	
	
	//=====已入住
	public Object queryByCheck() throws SQLException {
		return ee.queruByCheck();
		
	}
	//=====未入住
	public Object queryByNocke() throws SQLException {
		return ee.queryByNocheck();
	}
	
}
