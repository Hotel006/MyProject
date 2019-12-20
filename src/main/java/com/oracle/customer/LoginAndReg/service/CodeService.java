package com.oracle.customer.LoginAndReg.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import com.oracle.customer.LoginAndReg.dao.LogAndRegDao;
import com.oracle.entity.User_admin;
import com.oracle.util.SMGutil;

public class CodeService {

	public List resetByPhone(String phone) throws SQLException {
		if (!validateMobilePhone(phone)) {
			throw new RuntimeException("手机号码错误,请重新输入");
                                 
		}
		
		User_admin ua = new User_admin();
		LogAndRegDao lrd = new LogAndRegDao();
		ua = lrd.queryByPhone(phone);
		
		if (ua == null) {
			throw new RuntimeException("账号未注册，请先注册");
		}
		
		Random r = new Random();
		StringBuffer sb = new StringBuffer();// 验证码
		for (int i = 1; i <= 4; i++) {
			sb.append(r.nextInt(10));
		}
		
		SMGutil smg = new SMGutil();
		smg.sendValidateCode(phone, sb.toString());
		
		List list = new ArrayList();
		list.add(phone);
		list.add(sb.toString());
		return list;
		
		
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
