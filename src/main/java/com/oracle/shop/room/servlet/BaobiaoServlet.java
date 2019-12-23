package com.oracle.shop.room.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracle.entity.Hotel_order;
import com.oracle.shop.room.service.BaobiaoService;

/**
 * Servlet implementation class BaobiaoServlet
 */
public class BaobiaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaobiaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 返回的json字符串，对应的java类
				Map<String, Object> map = new HashMap<String, Object>();
				BaobiaoService hr = new BaobiaoService();
				try {
					response.setContentType("application/json;charset=utf-8");
					// 查询 判断
					List<Hotel_order> list = hr.queryAll();
					int hh = 0;
					for (int i = 0; i < list.size(); i++) {
						Hotel_order hs = list.get(i);
		
					 hh += Integer.parseInt(hs.getOmoney());
					}
					
					
					int sum = hh   ;
					
					
					
					
					map.put("sum", sum);
					map.put("data", list);
					map.put("result", true);
				} catch (Exception e) {
					map.put("result", false);
					map.put("msg", "没有找到报表信息");
				}
				// 返回给客户端信息
				response.getWriter().print(JSON.toJSONString(map));
			}
	

}
