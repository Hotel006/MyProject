package com.oracle.shop.check.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.oracle.entity.Hotel_order;
import com.oracle.util.DBHelper;

public class YudingDao {
	QueryRunner qr =new QueryRunner(DBHelper.ds);
	public List<Hotel_order> showroom(String room) throws SQLException{
		String sql ="SELECT\r\n" + 
				"hotel_order.oname,\r\n" + 
				"hotel_order.ophone,\r\n" + 
				"hotel_order.oroom,\r\n" + 
				"hotel_order.ohouse,\r\n" + 
				"hotel_order.oday,\r\n" + 
				"(SELECT rmoney FROM hotel_room WHERE rnumber=?) AS rmoney\r\n" + 
				"FROM\r\n" + 
				"hotel_order\r\n" + 
				"WHERE oroom=?\r\n" + 
				"";
		
		List<Hotel_order> list=qr.query(sql,new BeanListHandler<Hotel_order>(Hotel_order.class),room,room);
		return list;
	}
	public List<Hotel_order> showcheck(String room) throws SQLException {
		String sql ="SELECT rmoney FROM hotel_room WHERE rnumber=?";
		List<Hotel_order> list=qr.query(sql,new BeanListHandler<Hotel_order>(Hotel_order.class),room);
		return list;
	}	
	public String money(String phone) throws SQLException {
		String sql ="SELECT rmoney FROM hotel_room WHERE rnumber=(SELECT oroom FROM hotel_order WHERE ophone=? AND ooderstate ='0')";
		String money=qr.query(sql,new ScalarHandler<String>(),phone);
		System.out.println(money);
		return money;
	}	

}
