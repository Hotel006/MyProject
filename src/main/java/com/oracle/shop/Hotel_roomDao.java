package com.oracle.shop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.catalina.ssi.SSICommand;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.oracle.entity.Hotel_room;
import com.oracle.util.DBHelper;

public class Hotel_roomDao extends DBHelper {
	
	/*
	 * public Hotel_room queryById(int rid) throws SQLException { String sql =
	 * "SELECT * FROM hotel_room"; QueryRunner qr = new QueryRunner(DBHelper.ds);
	 * return qr.query(sql, rid, new BeanHandler<Hotel_room>(Hotel_room.class));
	 * 
	 * }
	 */
	//查询全部
	/*
	 * public Hotel_room queryAll() throws SQLException { String sql =
	 * "SELECT * FROM hotel_room"; QueryRunner qr = new QueryRunner(DBHelper.ds);
	 * return qr.query(sql, new BeanHandler<Hotel_room>(Hotel_room.class)); }
	 */
	public List<Hotel_room> queryAll() throws SQLException{
		List<Hotel_room> result = new ArrayList<Hotel_room>();
		String sql="SELECT * FROM hotel_room";
		QueryRunner qr = new QueryRunner(DBHelper.ds);
		List<Map<String, Object>> list = qr.query( sql, new MapListHandler());
		return result;
		
	}
	//增加房间
	/*
	 * public void save(Hotel_room sa) { QueryRunner qr = new
	 * QueryRunner(DBHelper.ds); String
	 * sql="INSERT INTO hotel_room (rnumber,rhouse,rmoney,rimg,rstatus)VALUES(?,?,?,?,?)"
	 * ; qr.update(sql, ) }
	 */
	
	
	/*
	 * sa.setzhuangtai(0); ss.save(as);
	 */
	
	//修改
	public void save(Hotel_room xg) throws SQLException {
		QueryRunner qr = new QueryRunner(DBHelper.ds);
		String sql = "INSERT INTO hotel_room (rnumber,rhouse,rmoney,rimg,rstatus)VALUES(?,?,?,?)";
		qr.update( sql, xg.getRnumber(), xg.getRhouse(),xg.getRmoney());
	}
	
}
