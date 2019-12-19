package com.oracle.shop.room.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.oracle.entity.Hotel_room;
import com.oracle.util.DBHelper;

public class AddRoomDao extends DBHelper {
	//房间号查询
	public Hotel_room queryByNumber(String number) throws SQLException {
		String sql = "SELECT * FROM hotel_room WHERE rnumber=?";
		QueryRunner qr = new QueryRunner(DBHelper.ds);
		return qr.query(sql, number, new BeanHandler<Hotel_room>(Hotel_room.class));

	}
	//添加房间
	public void save(Hotel_room ho) throws SQLException {
		QueryRunner qr = new QueryRunner(DBHelper.ds);
		String sql = "insert into hotel_room(rnumber,rhouse,rmoney,rimg,rbrief) values(?,?,?,?,?)";
		 qr.update(sql, ho.getRnumber(), ho.getRhouse(), ho.getRmoney(),ho.getRimg(),ho.getRbrief());
	}
}
