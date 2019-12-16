package com.oracle.customer.LoginAndReg.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

import com.oracle.customer.LoginAndReg.dao.LogAndRegDao;
import com.oracle.entity.User_admin;
import com.oracle.util.SMGutil;

public class LoginAndRegService {
	public void register(String phone,String nikename) throws SQLException {
		if (!validateMobilePhone(phone)) {
			throw new RuntimeException("手机号码错误,请重新输入");
                                 
		}
		
		User_admin ua = new User_admin();
		LogAndRegDao lrd = new LogAndRegDao();
		ua = lrd.queryByPhone(phone);
		
		if (ua != null) {
			throw new RuntimeException("账号已经注册，如忘记密码，请点击忘记密码进行密码修改操作");
		}
		
		Random r = new Random();
		StringBuffer sb = new StringBuffer();// 验证码
		for (int i = 1; i <= 4; i++) {
			sb.append(r.nextInt(10));
		}
		
		SMGutil smg = new SMGutil();
		smg.sendValidateCode(phone, sb.toString());
		
		User_admin uaa = new User_admin();
		uaa.setUloginname(phone);
		uaa.setUloginpass(sb.toString());
		uaa.setUnickname(nikename);
		
		lrd.save(uaa);
		
		
	}
	
	public User_admin login(String phone, String pass) throws Exception {
		User_admin ua = new User_admin();
		LogAndRegDao lar = new LogAndRegDao();
		if (ua == null) {
			throw new RuntimeException("账号不存在,请先注册");
		}
		if (!ua.getUloginpass().equals(pass)) {
			throw new RuntimeException("用户名或密码错误");
		}
		return ua;
	}
	
	
	
	
	
	public static final String REGEX_MOBILE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0-9]))\\d{8}$";

	/**
	 * 正则：手机号（简单）, 1字头＋10位数字即可.
	 * 
	 * @param in
	 * @return
	 */
	public static boolean validateMobilePhone(String in) {
		Pattern pattern = Pattern.compile(REGEX_MOBILE);
		return pattern.matcher(in).matches();
	}
}
