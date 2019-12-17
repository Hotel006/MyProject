package com.oracle.customer.Reserve.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oracle.entity.Hotel_room;
import com.oracle.util.DBHelper;

public class ReserveDao extends DBHelper{

	QueryRunner qr = new QueryRunner(DBHelper.ds);
	
	public List<Hotel_room> queryAllRooms() throws SQLException {
		String sql = "SELECT * FROM hotel_room";
		return qr.query(sql,new BeanListHandler<Hotel_room>(Hotel_room.class));
	}
	
	public void indent() throws SQLException {
		String sql = "";
		qr.update(sql);
	}
	
}
