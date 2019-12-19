package com.oracle.customer.Reserve.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracle.customer.Reserve.service.ReserveService;
import com.oracle.entity.Hotel_room;

/**
 * Servlet implementation class Reserve_Room_Servlet
 */
public class Reserve_Room_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reserve_Room_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReserveService rs = new ReserveService();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> hr = rs.queryRoomsNumber();
			if(hr.size()==0) {
				map.put("result",false);
			}else {
				map.put("result", true);
				map.put("data", hr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			map.put("result", false);
		}
		
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
