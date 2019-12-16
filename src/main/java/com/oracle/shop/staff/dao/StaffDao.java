package com.oracle.shop.staff.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oracle.entity.Hotel_staff;
import com.oracle.util.DBHelper;

public class StaffDao extends DBHelper {
	public List<Hotel_staff> queryAll() throws SQLException{
		List<Hotel_staff> list = new ArrayList<Hotel_staff>();
		
		String sql = "select * from hotel_staff";
		
		
		QueryRunner qr = new QueryRunner(DBHelper.ds);
		list = qr.query(sql, new BeanListHandler<Hotel_staff>(Hotel_staff.class));
		
		

		return list;
		
	}
}
