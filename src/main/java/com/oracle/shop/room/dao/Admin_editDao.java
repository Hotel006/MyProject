package com.oracle.shop.room.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.oracle.entity.Hotel_room;
import com.oracle.util.DBHelper;

public class Admin_editDao extends DBHelper {
	
	QueryRunner qr = new QueryRunner(DBHelper.ds);

	public void save(Hotel_room ho) throws SQLException {
		
		String sql = "insert into hotel_room(rnumber,rhouse,rmoney) values(?,?,?)";
		 qr.update(sql, ho.getRnumber(), ho.getRhouse(), ho.getRmoney());
	}
	
	public Hotel_room queryRoomByRnumber(String rnumber) throws SQLException {
		String sql = "";
		Hotel_room hr = qr.query(sql, rnumber,new BeanHandler<Hotel_room>(Hotel_room.class));
		return hr;
		
	}
	
	public void updateRoomByRnumber(String rnumber,String rhouse,String rmoney) throws SQLException {
		String sql = "UPDATE hotel_room SET rmoney=?,rhouse=? WHERE rnumber=?";
		Hotel_room hr = new Hotel_room();
		 Object[] params = {rmoney,rhouse,rnumber};
		qr.update(sql, params);
	}
}