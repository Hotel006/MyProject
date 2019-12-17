package com.oracle.shop.check.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracle.entity.Hotel_order;
import com.oracle.entity.Hotel_room;
import com.oracle.shop.check.service.QueryService;
import com.oracle.shop.check.service.ShowRoomService;
import com.oracle.util.AjaxResult;

/**
 * Servlet implementation class ShowRoomServlet
 */
public class ShowRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		AjaxResult result = new AjaxResult();
		ShowRoomService sService =new ShowRoomService();
		try {
			List<Hotel_room> list =sService.showroom();
			result.setDatas(list);
		} catch (SQLException e) {
			result.setResult(false);
			result.setMsg(e.getMessage());
			e.printStackTrace();
		}
		String json=JSON.toJSONString(result);
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
