package com.oracle.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据库访问工具类
 * 
 * @author Administrator
 *
 */
public class DBHelper {
	private static Properties properties;
	private static DBHelper druid;
	// 整个系统中是唯一的
	public static DruidDataSource ds;

	static {
		properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("druid.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (druid == null) {
			druid = new DBHelper();

		}
	}

	/**
	 * 创建单列模式
	 * 
	 * @return JDBCDruid实例
	 */
	public static synchronized DBHelper getInstance() {
		if (druid == null) {
			druid = new DBHelper();
			return druid;
		}
		return druid;
	}

	public DBHelper() {

		ds = new DruidDataSource();
		ds.setDriverClassName(properties.getProperty("driverClassName"));
		ds.setUrl(properties.getProperty("url"));
		ds.setUsername(properties.getProperty("username"));
		ds.setPassword(properties.getProperty("password"));
		ds.setMaxActive(Integer.parseInt(properties.getProperty("maxActive")));

	}

}
