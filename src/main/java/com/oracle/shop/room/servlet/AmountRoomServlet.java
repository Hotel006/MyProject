package com.oracle.shop.room.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.xmlrpc.base.Data;
import com.oracle.shop.room.service.AmountRoomService;

/**
 * Servlet implementation class AmountRoomServlet
 */
public class AmountRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmountRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> map = new HashMap<String,Object>();
		
		response.setContentType("application/json;charset=utf-8");
		
	
		
			
				
				
		try {
			List list = new ArrayList();
			AmountRoomService ars = new AmountRoomService();
			int check = ((Long)ars.queryByCheck()).intValue();
			int nocke = ((Long)ars.queryByNocke()).intValue();
			int sum = ((Long)ars.queryBySum()).intValue();
			int type = ((Long)ars.queryByType()).intValue();
			System.out.println(check);
			System.out.println(nocke);
			System.out.println(sum);
			System.out.println(type);
			
			
			list.add(check);
			list.add(nocke);
			list.add(sum);
			list.add(type);
			
			map.put("data",list);
			map.put("result",true);
		} catch (Exception e) {
			map.put("result", false);
			System.out.println(e.getMessage());
		}
		//返回给客户端信息
		response.getWriter().print(JSON.toJSONString(map));

		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
