package com.oracle.shop.check.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.oracle.util.DBHelper;

public class CheckDao {
	QueryRunner qr =new QueryRunner(DBHelper.ds);
	public void ydcheck(long onumber, String name, String phone, int totlemoney, int oday, String nowtime, String outtime, String cardid) throws SQLException {
		String sql="UPDATE hotel_order SET\r\n" + 
				"hotel_order.onumber=?,\r\n" + 
				"hotel_order.oname=?,\r\n" + 
				"hotel_order.ocount=?,\r\n" + 
				"hotel_order.omoney=?,\r\n" + 
				"hotel_order.oday=?,\r\n" + 
				"hotel_order.oontime=?,\r\n" + 
				"hotel_order.oyjouttime=?,\r\n" + 
				"hotel_order.ooderstate=?,\r\n" + 
				"hotel_order.ocard=?\r\n" + 
				"WHERE ophone =?";
		qr.update(sql,onumber,name,1,totlemoney,oday,nowtime,outtime,1,cardid,phone);
	String sql1="UPDATE hotel_room SET rstatus='1' WHERE rnumber= (SELECT oroom FROM hotel_order WHERE ophone=?)";
	qr.update(sql1,phone);
	}
	public void check(long onumber, String oname, String ophone, int totlemoney, String oroom, String type, int oday, String nowtime, String outtime, String cardid) throws SQLException {
		String osource="前台办理";
		String sql="INSERT INTO hotel_order\r\n" + 
				"(hotel_order.onumber,\r\n" + 
				"hotel_order.oname,\r\n" + 
				"hotel_order.ophone,\r\n" + 
				"hotel_order.oroom,\r\n" + 
				"hotel_order.ohouse,\r\n" + 
				"hotel_order.ocount,\r\n" + 
				"hotel_order.omoney,\r\n" + 
				"hotel_order.oday,\r\n" + 
				"hotel_order.oontime,\r\n" + 
				"hotel_order.oyjouttime,\r\n" + 
				"hotel_order.ooderstate,\r\n" + 
				"hotel_order.osource,\r\n" + 
				"hotel_order.ocard)\r\n" + 
				"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println("开始存了");
		qr.update(sql,onumber,oname,ophone,oroom,type,1,totlemoney,oday,nowtime,outtime,1,osource,cardid);
	String sql1="UPDATE hotel_room SET rstatus='1' WHERE rnumber= ?";
	qr.update(sql1,oroom);
	}
	

}
