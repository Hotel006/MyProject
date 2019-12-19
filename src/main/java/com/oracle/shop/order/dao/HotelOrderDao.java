package com.oracle.shop.order.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oracle.entity.Hotel_order;
import com.oracle.util.DBHelper;

public class HotelOrderDao extends DBHelper{
	
	QueryRunner q = new QueryRunner(DBHelper.ds);

	public List<Hotel_order> queryAll() throws SQLException {
	
		String sql="select * from hotel_order";
		List<Hotel_order> list = q.query(sql,new BeanListHandler<Hotel_order>(Hotel_order.class));	
		System.out.println(list);
		return list;
	}
	
	

	public List<Hotel_order> queryByOhouse(String ohouse) throws SQLException {
		
		
//		QueryRunner qr = new QueryRunner(DBHelper.ds);
		String sql = "SELECT*FROM hotel_order WHERE ohouse=?";
		return q.query(sql, ohouse,new BeanListHandler<Hotel_order>(Hotel_order.class));
		
	}
	
	
	public List<Hotel_order> queryByOsource(String osource) throws SQLException {
		
//		QueryRunner qru = new QueryRunner(DBHelper.ds);
		String sql = "SELECT*FROM hotel_order WHERE osource=?";
		return q.query(sql, osource,new BeanListHandler<Hotel_order>(Hotel_order.class));
		
	}
	
	
	public List<Hotel_order> queryByOphone(String ophone) throws SQLException {
		
//		QueryRunner qu = new QueryRunner(DBHelper.ds);
		String sql = "SELECT*FROM hotel_order WHERE ophone=?";
		return q.query(sql, ophone,new BeanListHandler<Hotel_order>(Hotel_order.class));
	}
	
	
	public List<Hotel_order> queryByOnumber(String onumber) throws SQLException {
		
//		QueryRunner quer = new QueryRunner(DBHelper.ds);
		String sql = "SELECT*FROM hotel_order WHERE onumber=?";
		return q.query(sql, onumber,new BeanListHandler<Hotel_order>(Hotel_order.class));
	}
	
	
	public List<Hotel_order> queryDeleteOnumber(String onumber) throws SQLException {
		
//		QueryRunner qn = new QueryRunner(DBHelper.ds);
		String sql = "DELETE FROM hotel_order WHERE onumber=?;\r\n";
		return q.query(sql, onumber,new BeanListHandler<Hotel_order>(Hotel_order.class));	
		
		
	}

}
