package com.oracle.customer.order.servlet;

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
import com.oracle.customer.order.service.CustomerOrderDetailsService;
import com.oracle.customer.order.service.CustomerOrderService;
import com.oracle.entity.Hotel_order;

/**
 * Servlet implementation class CustomerOrderDateilsServlet
 */
public class CustomerOrderDateilsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerOrderDateilsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("application/json;charset=utf-8");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		CustomerOrderDetailsService cos = new CustomerOrderDetailsService();
		
		
		
		try {
			
			List<Hotel_order> list = cos.queryByDetails() ;
			System.out.println(list.size());
			map.put("result", true);
			map.put("data", list);
		} catch (SQLException e) {
			map.put("msg", e.getMessage());

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
