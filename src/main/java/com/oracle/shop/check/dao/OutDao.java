package com.oracle.shop.check.dao;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;

import com.oracle.util.DBHelper;

public class OutDao {
	QueryRunner qr =new QueryRunner(DBHelper.ds);
	public void out(String hnumber, String hpeople, String hphone, String hhouse, String hcount, String hmoney, Date hontime, String houttime, String hsource, String hcard) throws SQLException {
		String sql="DELETE FROM hotel_order WHERE onumber=?";
		qr.update(sql,hnumber);
	String sql1="INSERT INTO `hotel_historyorder`(`hnumber`, `hpeople`, `hphone`, `hhouse`, `hcount`, `hmoney`, `hontime`, `houttime`, `hsource`, `hcard`) VALUES  (?,?,?,?,?,?,?,?,?,?)";
	qr.update(sql1,hnumber,hpeople,hphone,hhouse,hcount,hmoney,hontime,houttime,hsource,hcard);
	String sql2="UPDATE hotel_room SET rstatus=1 WHERE rnumber =?";
	qr.update(sql2, hcount);
	}
	public void clean(String room) throws SQLException {
		String sql="UPDATE hotel_order SET ooderstate=2 WHERE oroom =?";
		qr.update(sql, room);
	}
	public void xuzhu(String room, int day) throws SQLException {
		String sql="UPDATE hotel_order SET oday=?  WHERE oroom =?";
		qr.update(sql, day,room);
	}
	public void changeRoom(String room, String text) throws SQLException {
		String sql="UPDATE hotel_order SET ochangeroom=? AND oroom=? WHERE oroom =?";
		qr.update(sql, room,text,room);
	}
}
