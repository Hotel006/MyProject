package com.oracle.shop.loginandreg.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracle.entity.Hotel_admin;
import com.oracle.shop.loginandreg.service.LoginService;

/**
 * Servlet implementation class LoginRegServlet
 */
public class ShopLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		String loginname = request.getParameter("username");
		String loginpass = request.getParameter("password");
		System.out.println(loginname);
		LoginService ls = new LoginService();
		try {
			Hotel_admin ha  = ls.login(loginname, loginpass);
			
			request.getSession().setAttribute("SESSIONUSER", ha);
			
			
			map.put("result", true);
			
			response.getWriter().print(JSON.toJSONString(map));
			

		} catch (Exception e) {
			map.put("msg", e.getMessage());
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
