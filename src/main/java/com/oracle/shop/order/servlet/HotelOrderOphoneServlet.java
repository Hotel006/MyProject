package com.oracle.shop.order.servlet;

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
import com.oracle.entity.Hotel_order;
import com.oracle.shop.order.service.HotelOrderOphoneService;

/**
 * Servlet implementation class HotelOrderOphoneServlet
 */
public class HotelOrderOphoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelOrderOphoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json,charset=utf-8");
		Map<String, Object> map = new HashMap<String, Object>();
		HotelOrderOphoneService hop = new HotelOrderOphoneService();
		
		
		try {
			Hotel_order ho = new Hotel_order();
			List<Hotel_order> list = hop.queryByOphone(ho.getOphone());
			map.put("result", true);
			map.put("data", false);
		} catch (SQLException e) {
			map.put("result", true);
			map.put("msg", "没有找到订单信息");	
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
