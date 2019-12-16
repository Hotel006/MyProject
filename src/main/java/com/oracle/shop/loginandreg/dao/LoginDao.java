package com.oracle.shop.loginandreg.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.oracle.entity.Hotel_admin;
import com.oracle.util.DBHelper;

public class LoginDao {
	public Hotel_admin queryByLoginName(String loginname) throws SQLException {
		String sql = "select * from  hotel_admin where aloginname=?";
		QueryRunner qr = new QueryRunner(DBHelper.ds);
		return qr.query(sql, loginname, new BeanHandler<Hotel_admin>(Hotel_admin.class));

	}
}
