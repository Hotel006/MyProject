package com.oracle.customer.LoginAndReg.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.oracle.entity.User_admin;
import com.oracle.util.DBHelper;

public class LogAndRegDao extends DBHelper {
	
	public User_admin queryByPhone(String phone) throws SQLException {
		String sql = "select * from  user_admin where uloginname=?";
		QueryRunner qr = new QueryRunner(DBHelper.ds);
		return qr.query(sql, phone, new BeanHandler<User_admin>(User_admin.class));

	}
	
	public void save(User_admin ua) throws SQLException {
		QueryRunner qr = new QueryRunner(DBHelper.ds);

		String sql = "insert into user_admin(\r\n" + 
				"user_admin.uloginname,\r\n" + 
				"user_admin.uloginpass,\r\n" + 
				"user_admin.unickname)VALUES(?,?,?)";
		qr.update(sql, ua.getUloginname(), ua.getUloginpass(), ua.getUnickname());
	}
	
	
}
