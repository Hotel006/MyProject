package com.oracle.shop.room.servlet;

import java.io.Console;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.group.GroupChannel.HeartbeatThread;

import com.alibaba.fastjson.JSON;
import com.oracle.entity.Hotel_order;
import com.oracle.shop.room.service.BaobiaoService;
import com.oracle.shop.room.service.Hotel_roomService;

/**
 * Servlet implementation class BaobiaoServlet2
 */
public class BaobiaoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaobiaoServlet2() {
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
		response.setContentType("application/json;charset=utf-8");

		Map<String, Object>map = new HashMap<String, Object>();
		//取值
		String year = request.getParameter("useryear"); 
		String month = request.getParameter("usermonth"); 
	
		System.out.println(year);
		System.out.println(month);
		
		 BaobiaoService bs = new BaobiaoService();
		 Hotel_order ho = new Hotel_order();
		 
		 try {
			 if (month!=null) {
				 List<Hotel_order> list = bs.queryMonth();
					map.put("data",list);	
					map.put("result", true);
			} else {
				
				 List<Hotel_order> list = bs.queryYear();
					map.put("data",list);	
					map.put("result", true);
			}
			
		} catch (SQLException e) {
			map.put("result", false);
			map.put("msg", "没有找到报表信息");
			
		}
		//返回给客户端信息
			response.getWriter().print(JSON.toJSONString(map));
		
	}

}
