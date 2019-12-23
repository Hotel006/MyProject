package com.oracle.shop.room.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oracle.entity.Hotel_order;
import com.oracle.util.DBHelper;

public class BaobiaoDao extends DBHelper {
	//查询全部
	QueryRunner qr = new QueryRunner(DBHelper.ds);
	public List<Hotel_order> queryAll() throws SQLException{
		String sql="SELECT\r\n" + 
				"hotel_order.oontime,\r\n" + 
				"hotel_order.oname,\r\n" + 
				"hotel_order.oroom,\r\n" + 
				"hotel_order.ohouse,\r\n" + 
				"hotel_order.ophone,\r\n" + 
				"hotel_order.omoney\r\n" + 
				"FROM\r\n" + 
				"hotel_order\r\n" + 
				"";
		
		List<Hotel_order> list = qr.query(sql,new BeanListHandler<Hotel_order>(Hotel_order.class));
		return list;
		
	}
	
	//通过年份查询
	public List<Hotel_order> queryYear() throws SQLException {
		String sql = "select * from hotel_order where Year(oontime) = ?";
		List<Hotel_order> list  = qr.query(sql, new BeanListHandler<Hotel_order>(Hotel_order.class));
		return list;
		
	}
	//通过月份分查询
	public List<Hotel_order> queryMonth() throws SQLException {
		String sql = "select * from hotel_order where Year(oontime) = ? and Month(oontime) =?";
		List<Hotel_order> list  = qr.query(sql, new BeanListHandler<Hotel_order>(Hotel_order.class));
		return list;
		
	}
}
