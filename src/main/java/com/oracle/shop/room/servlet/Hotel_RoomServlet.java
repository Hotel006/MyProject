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
import com.oracle.entity.Hotel_room;
import com.oracle.shop.room.service.Hotel_roomService;

/**
 * Servlet implementation class Hotel_RoomServlet
 */
public class Hotel_RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hotel_RoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 返回的json字符串，对应的java类
				Map<String, Object>map = new HashMap<String, Object>();
				Hotel_roomService hr = new Hotel_roomService();
				try {
					response.setContentType("application/json;charset=utf-8");
					//查询 判断 
					List<Hotel_room> list  =  hr.queryAll();
							
					map.put("data",list);	
					map.put("result", true);
				} catch (Exception e) {
					map.put("result", false);
					map.put("msg", "没有找到房间信息");
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
