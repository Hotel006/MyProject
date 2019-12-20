package com.oracle.customer.LoginAndReg.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracle.customer.LoginAndReg.service.CodeService;
import com.oracle.customer.LoginAndReg.service.LoginAndRegService;

/**
 * Servlet implementation class CodeServlet
 */
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeServlet() {
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
		List list = new ArrayList();
		String phone = request.getParameter("phone");
		CodeService cs = new CodeService();
		
		
		try {
			list = cs.resetByPhone(phone);
			map.put("result", true);
			map.put("data", list);
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
