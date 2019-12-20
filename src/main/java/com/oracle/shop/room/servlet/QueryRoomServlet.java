package com.oracle.shop.room.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracle.entity.Hotel_room;
import com.oracle.shop.room.service.QueryRoomservice;
import com.oracle.util.AjaxResult;

/**
 * Servlet implementation class QueryRoomServlet
 */
public class QueryRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进来了");
		AjaxResult result =new AjaxResult();
		try {
			List<Hotel_room> list=new QueryRoomservice().queryallroom();
			result.setDatas(list);
		} catch (SQLException e) {
			result.setMsg(e.getMessage());
			result.setResult(false);
			e.printStackTrace();
		}
		String json =JSON.toJSONString(result);
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
