package com.oracle.shop.staff.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oracle.entity.Hotel_staff;
import com.oracle.entity.User_admin;
import com.oracle.util.DBHelper;
import com.oracle.util.DateUtil;

public class StaffDao extends DBHelper {
	public List<Hotel_staff> queryAll() throws SQLException{
		List<Hotel_staff> list = new ArrayList<Hotel_staff>();
		
		String sql = "select * from hotel_staff";
		
		
		QueryRunner qr = new QueryRunner(DBHelper.ds);
		list = qr.query(sql, new BeanListHandler<Hotel_staff>(Hotel_staff.class));
		
		

		return list;
		
	}
	
	public Hotel_staff queryByUsername(String username) throws SQLException{
		Hotel_staff sf = new Hotel_staff();
		
		String sql = "select * from  hotel_staff where sentername=?";
		
		
		QueryRunner qr = new QueryRunner(DBHelper.ds);
		sf = qr.query(sql,username, new BeanHandler<Hotel_staff>(Hotel_staff.class));
		
		return sf;
		
	}
	
	public void save(Hotel_staff sf) throws SQLException {
		QueryRunner qr = new QueryRunner(DBHelper.ds);

		String sql = "insert into hotel_staff(\r\n" + 
				"hotel_staff.sname,\r\n" + 
				"hotel_staff.ssex,\r\n" + 
				"hotel_staff.sage,\r\n" + 
				"hotel_staff.sbirthday,\r\n" + 
				"hotel_staff.sphone,\r\n" + 
				"hotel_staff.sentername,\r\n" + 
				"hotel_staff.senterpass)\r\n" + 
				"values(?,?,?,?,?,?,?)";
		qr.update(sql,sf.getSname(),sf.getSsex(),sf.getSage(),sf.getSbirthday(),sf.getSphone(),sf.getSentername(),sf.getSenterpass());
		
	}
}
