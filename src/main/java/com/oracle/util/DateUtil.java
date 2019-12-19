package com.oracle.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

public class DateUtil {
	public static final String PATTEN1 = "yyyy年MM月dd日HH时mm分ss秒";
	public static final String Y="yyyyMMdd HH:mm:ss";
	public static final String H="yyyy-MM-dd HH:mm:ss";
	public static final String D="yyyy-MM-dd";
	public static final String F="HH";
	public static final String G="dd";
	/**
	 * 字符串转换为时间
	 * @param time
	 * @param format
	 * @return
	 */
	public static Date stringtodate(String time,String format) {
		SimpleDateFormat sd=new SimpleDateFormat(format);
		try {
			return sd.parse(time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 日期转换为字符串
	 * @param time
	 * @param format
	 * @return
	 */
	public static String datetostring(Date time,String format) {
		SimpleDateFormat sd=new SimpleDateFormat(format);
		return sd.format(time);
	}
	/**
	 * 获取当前时间
	 * @param format
	 * @return
	 */
	public static String nowtime(String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);//设置日期格式
		String time=df.format(new Date());
		return time;
	}
	/**
	 * 退房时间更改为day天后的12点
	 * @return
	 */
	public static String nexttime(int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_YEAR, day);
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return  datetostring(cal.getTime(), H);
	}
	/**
	 * 给文本框添加刷新时间时间
	 * @param lblTime
	 */
	public void setLableTime(JLabel lblTime) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					SimpleDateFormat df = new SimpleDateFormat(Y);

					lblTime.setText(df.format(new Date()));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();

	}
	
	public static String getDate(String patten) {
		String strDate = new SimpleDateFormat(patten).format(new Date());
		return strDate;

	}
	

}



