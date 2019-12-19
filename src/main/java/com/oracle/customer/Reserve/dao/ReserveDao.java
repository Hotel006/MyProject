package com.oracle.customer.Reserve.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.oracle.entity.Hotel_room;
import com.oracle.util.DBHelper;

public class ReserveDao extends DBHelper{

	QueryRunner qr = new QueryRunner(DBHelper.ds);
	
	public List<Hotel_room> queryAllRooms() throws SQLException {
		String sql = "SELECT * FROM hotel_room where rstatus=1";
		return qr.query(sql,new BeanListHandler<Hotel_room>(Hotel_room.class));
	}
	
	public List<Map<String, Object>> queryRoomsNumber() throws SQLException{
		String sql = "SELECT rhouse as rhouse,COUNT(*) as number FROM hotel_room where rstatus=1 GROUP BY rhouse";
		return qr.query(sql,new MapListHandler());
	}
	
	public void indent() throws SQLException {
		String sql = "";
		qr.update(sql);
	}
	
}
