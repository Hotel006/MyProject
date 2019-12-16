package com.oracle.shop.order.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oracle.entity.Hotel_order;
import com.oracle.util.DBHelper;

public class HotelOrderDao extends DBHelper{
	public List<Hotel_order> queryAll() throws SQLException {
	
		QueryRunner q = new QueryRunner(DBHelper.ds);
		String sql="SELECT\r\n" + 
				"hotel_order.onumber,\r\n" + 
				"hotel_order.oname,\r\n" + 
				"hotel_order.ophone,\r\n" + 
				"hotel_order.oroom,\r\n" + 
				"hotel_order.ohouse,\r\n" + 
				"hotel_order.ocount,\r\n" + 
				"hotel_order.omoney,\r\n" + 
				"hotel_order.oydontime,\r\n" + 
				"hotel_order.oontime,\r\n" + 
				"hotel_order.oyjouttime,\r\n" + 
				"hotel_order.oouttime,\r\n" + 
				"hotel_order.ooderstate,\r\n" + 
				"hotel_order.osource,\r\n" + 
				"hotel_order.ocard\r\n" + 
				"FROM\r\n" + 
				"hotel_order\r\n";
		List<Hotel_order> list = q.query(sql,new BeanListHandler<Hotel_order>(Hotel_order.class));	
		return list;

	}
	
	
	

	public List<Hotel_order> queryByOhouse(String ohouse) throws SQLException {
		
		
		QueryRunner qr = new QueryRunner(DBHelper.ds);
		String sql = "SELECT*FROM hotel_order WHERE ohouse=?";
		return qr.query(sql, ohouse,new BeanListHandler<Hotel_order>(Hotel_order.class));
		
	}
	
	
	public List<Hotel_order> queryByOsource(String osource) throws SQLException {
		
		QueryRunner qru = new QueryRunner(DBHelper.ds);
		String sql = "SELECT*FROM hotel_order WHERE osource=?";
		return qru.query(sql, osource,new BeanListHandler<Hotel_order>(Hotel_order.class));
		
	}
	
	
	public List<Hotel_order> queryByOphone(String ophone) throws SQLException {
		
		QueryRunner qu = new QueryRunner(DBHelper.ds);
		String sql = "SELECT*FROM hotel_order WHERE ophone=?";
		return qu.query(sql, ophone,new BeanListHandler<Hotel_order>(Hotel_order.class));
	}
	
	
	public List<Hotel_order> queryByOnumber(String onumber) throws SQLException {
		
		QueryRunner quer = new QueryRunner(DBHelper.ds);
		String sql = "SELECT*FROM hotel_order WHERE onumber=?";
		return quer.query(sql, onumber,new BeanListHandler<Hotel_order>(Hotel_order.class));
	}

}
