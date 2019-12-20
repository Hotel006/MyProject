package com.oracle.shop.check.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oracle.entity.Hotel_order;
import com.oracle.util.DBHelper;

public class QueryDao {
	QueryRunner qr =new QueryRunner(DBHelper.ds);
	public List<Hotel_order> queryyuding() throws SQLException{
		String sql ="SELECT * FROM hotel_order WHERE ooderstate = '0'";
		List<Hotel_order> list=qr.query(sql,new BeanListHandler<Hotel_order>(Hotel_order.class));
		return list;
	}
	public List<Hotel_order> queryruzhu() throws SQLException{
		String sql ="SELECT * FROM hotel_order WHERE ooderstate = '1' or ooderstate='2' or ooderstate='3' or ooderstate='4'";
		List<Hotel_order> list=qr.query(sql,new BeanListHandler<Hotel_order>(Hotel_order.class));
		return list;
	}
	public void upmsdatestate(String room) throws SQLException{
		String sql ="UPDATE hotel_order SET ooderstate ='3' WHERE oroom=?";
		qr.update(sql,room);
	}
	public void updatestate(String room) throws SQLException{
		String sql ="UPDATE hotel_order SET ooderstate ='4' WHERE oroom=?";
		qr.update(sql,room);
	}

}
