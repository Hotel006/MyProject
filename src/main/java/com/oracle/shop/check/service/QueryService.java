package com.oracle.shop.check.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.entity.Hotel_order;
import com.oracle.shop.check.dao.CheckDao;
import com.oracle.shop.check.dao.QueryDao;

public class QueryService {
	QueryDao qDao =new QueryDao();
	public List<Hotel_order> queryyuding() throws SQLException{
		return qDao.queryyuding();
	}
	public List<Hotel_order> queryruzhu() throws SQLException{
		return qDao.queryruzhu();
	}

}
