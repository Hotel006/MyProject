package com.oracle.shop.staff.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_staff;
import com.oracle.shop.staff.dao.StaffDao;

public class StaffService {
	public List<Hotel_staff> queryAll() throws SQLException {
			StaffDao sd = new StaffDao();
			return sd.queryAll();
		
	}
	
	public void save(Hotel_staff st) throws SQLException {
		
		StaffDao sd = new StaffDao();
		
		
		 sd.save(st);
	
	}
	public Hotel_staff queryByUsername(String username) throws SQLException {
		StaffDao sd = new StaffDao();
		return sd.queryByUsername(username);
	
}
	public List<Hotel_staff> queryByRelname(String relname) throws SQLException {
		StaffDao sd = new StaffDao();
		
		return sd.queryByRelname(relname);
				
		
	}
	
	public List<Hotel_staff> queryByPhone(String phone) throws SQLException {
		StaffDao sd = new StaffDao();

		return sd.queryByPhone(phone);
		
	}
	
	public List<Hotel_staff> queryByPhoneAndName(String phone,String relname) throws SQLException {
		StaffDao sd = new StaffDao();

		return sd.queryByPhoneAndName(phone,relname);
		
	}
}
