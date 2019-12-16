package com.oracle.shop.loginandreg.service;

import com.oracle.entity.Hotel_admin;
import com.oracle.shop.loginandreg.dao.LoginDao;

public class LoginService {
	public Hotel_admin login(String loginname, String loginpass) throws Exception {
		Hotel_admin ha = LoginDao.queryByLoginName(loginname);
		if (ha == null) {
			throw new RuntimeException("账号不存在,请先注册");
		}
		if (!ha.getAloginpass().equals(loginpass)) {
			throw new RuntimeException("用户名或密码错误");
		}
		return ha;
	}
}
