package com.oracle.shop.room.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.oracle.entity.Hotel_room;
import com.oracle.shop.room.service.Admin_editService;

/**
 * Servlet implementation class Admin_editServlet
 */
public class Admin_editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_editServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		//取值
		String rnumber = request.getParameter("username");
		String rhouse = request.getParameter("roommoney");
		String rmoney = request.getParameter("roomcount");
	
		//调用
		Admin_editService aes = new Admin_editService();
		Hotel_room ar = new Hotel_room();
	
		try {
			aes.Alter(rnumber,rhouse,rmoney);
			
			
			map.put("result", true);
		} catch (SQLException e) {
			map.put("result", false);
			map.put("msg", e.getMessage());
		}
		
		
		response.getWriter().print(JSONObject.toJSONString(map));
		
		
	}
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
