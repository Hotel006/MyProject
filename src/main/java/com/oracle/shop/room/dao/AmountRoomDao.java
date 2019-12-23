package com.oracle.shop.room.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.oracle.entity.Hotel_room;
import com.oracle.util.DBHelper;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class AmountRoomDao extends DBHelper {

	//查询房间总数
	QueryRunner qr = new QueryRunner(DBHelper.ds);
	public Object queryBySum() throws SQLException {
		String sql = "SELECT COUNT(*) FROM hotel_room";
		return qr.query(sql,new ScalarHandler());
	}
	
	
	//查询房间类型总数
	public Object queryByType() throws SQLException {
		String sql ="select count(distinct rhouse)rhouse FROM hotel_room"; 
		return qr.query(sql, new ScalarHandler());
	}
	
	
	//查询已入住房间的总数
	public Object queruByCheck() throws SQLException {
		String sql="SELECT COUNT(*) FROM hotel_room WHERE rstatus='0'";
		return qr.query(sql,new ScalarHandler());
	}
	
	
	//查询未入住房间的总数
	public Object queryByNocheck() throws SQLException {
		String sql="SELECT COUNT(*) FROM hotel_room WHERE rstatus='1'";
		return qr.query(sql,new ScalarHandler());
	}
}
