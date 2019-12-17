package com.oracle.shop.room.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.oracle.entity.Hotel_room;
import com.oracle.util.DBHelper;

public class AddRoomDao extends DBHelper {
	
	@SuppressWarnings("deprecation")
	public Hotel_room queryByNumber(String number) throws SQLException {
		String sql = "select * from  host_room where rnumber=?";
		QueryRunner qr = new QueryRunner(DBHelper.ds);
		return qr.query(sql, number, new BeanHandler<Hotel_room>(Hotel_room.class));

	}

	public void save(Hotel_room ho) throws SQLException {
		QueryRunner qr = new QueryRunner(DBHelper.ds);

		String sql = "insert into hotel_room(\r\n" + 
				"hotel_room.rnumber,\r\n" + 
				"hotel_room.rhouse,\r\n" + 
				"hotel_room.rmoney,\r\n" + 
				"hotel_room.rimg,\r\n" + 
				"values(?,?,?,?);";
		qr.update(sql, ho.getRnumber(), ho.getRhouse(), ho.getRmoney(),ho.getRimg());
	}
}
