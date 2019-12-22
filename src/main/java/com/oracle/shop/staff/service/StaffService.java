package com.oracle.shop.staff.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.oracle.entity.Hotel_staff;
import com.oracle.shop.staff.dao.StaffDao;
import com.oracle.util.DateUtil;

public class StaffService {
	public List<Hotel_staff> queryAll() throws SQLException {
			StaffDao sd = new StaffDao();
			return sd.queryAll();
		
	}
	
	public void save(Hotel_staff st) throws SQLException {
		
		StaffDao sd = new StaffDao();
		Date time = st.getSbirthday();
		String srtime=DateUtil.datetostring(time, DateUtil.D);
		
		 sd.save(st,srtime);
	
	}
	public Hotel_staff queryByUsername(String username) throws SQLException {
		StaffDao sd = new StaffDao();
		return sd.queryByUsername(username);
	
}
	public List<Hotel_staff> queryByRelname(String relname) throws SQLException {
		StaffDao sd = new StaffDao();
		List<Hotel_staff> list = sd.queryByRelname(relname);
		System.out.println(list.size());
		return list;
				
		
	}
	
	public List<Hotel_staff> queryByPhone(String phone) throws SQLException {
		StaffDao sd = new StaffDao();

		return sd.queryByPhone(phone);
		
	}
	
	public List<Hotel_staff> queryByPhoneAndName(String phone,String relname) throws SQLException {
		StaffDao sd = new StaffDao();

		return sd.queryByPhoneAndName(phone,relname);
		
	}
	public void deleteStaffById(int id) throws Exception {
		StaffDao sd = new StaffDao();
			sd.deleteStaffById(id);
	
	}
	
	
	public void updateById(int id,String pass,String phone) throws SQLException {
		StaffDao sd = new StaffDao();
		
		 sd.updateById(id,pass,phone);
	}
}
