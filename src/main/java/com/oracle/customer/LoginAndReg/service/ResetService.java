package com.oracle.customer.LoginAndReg.service;

import java.sql.SQLException;

import com.oracle.customer.LoginAndReg.dao.LogAndRegDao;

public class ResetService {

	public void updatePass(String phone,String code,String pass,String relcode,String relphone) throws SQLException {
		LogAndRegDao lrd = new LogAndRegDao();
		
		
		if(code.equals(relcode)!=true) {
			System.out.println("relphone-->"+relphone);
			System.out.println("relcode-->"+relcode);
			throw new RuntimeException("验证码错误，请重新输入或获取");
		}
		if(phone.equals(relphone)!=true) {
			throw new RuntimeException("此验证码不属于本手机号，请重新输入电话号码或获取验证码");
		}
		
		lrd.updatePass(phone,pass);
		
	}
	
}
