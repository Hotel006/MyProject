package com.oracle.customer.LoginAndReg.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracle.customer.LoginAndReg.service.LoginAndRegService;
import com.oracle.entity.User_admin;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		String phone = request.getParameter("loginname");
		String pass = request.getParameter("loginpass");
		LoginAndRegService ls = new LoginAndRegService();
		
		try {
			User_admin ua = ls.login(phone, pass);
			
			request.getSession().setAttribute("User_admin", ua);
			map.put("result", true);
			
			
		} catch (Exception e) {
			map.put("result", false);
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
