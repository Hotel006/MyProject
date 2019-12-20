package com.oracle.customer.LoginAndReg.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;   
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracle.customer.LoginAndReg.service.LoginAndRegService;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		Map<String,Object> map = new HashMap();
		//获取电话号码和昵称，准备注册
		String phone = request.getParameter("phone");
		String nikename = request.getParameter("nikename");
		//调用service
		LoginAndRegService reg = new LoginAndRegService();
		
		try {
			reg.register(phone,nikename);
			map.put("result", true);
		} catch (SQLException e) {
			map.put("msg", e.getMessage());
		}
		
		response.getWriter().print(JSON.toJSONString(map));
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

