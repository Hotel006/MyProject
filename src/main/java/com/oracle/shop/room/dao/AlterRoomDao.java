package com.oracle.shop.room.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.oracle.entity.Hotel_room;
import com.oracle.util.DBHelper;

public class AlterRoomDao extends DBHelper{

	//修改
		public void save(Hotel_room xg) throws SQLException {
			QueryRunner qr = new QueryRunner(DBHelper.ds);
			String sql = "INSERT INTO hotel_room (rnumber,rhouse,rmoney,rimg,rstatus)VALUES(?,?,?,?)";
			qr.update( sql, xg.getRnumber(), xg.getRhouse(),xg.getRmoney());
		}
}
