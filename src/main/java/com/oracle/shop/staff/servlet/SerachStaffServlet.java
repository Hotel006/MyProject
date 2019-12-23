package com.oracle.shop.staff.servlet;

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
import com.oracle.entity.Hotel_staff;
import com.oracle.shop.staff.service.StaffService;

/**
 * Servlet implementation class SerachStaffServlet
 */
public class SerachStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerachStaffServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String phone = request.getParameter("mphone");
		String name = request.getParameter("mname");
		Map<String,Object> map = new HashMap<String,Object>();
		StaffService ss = new StaffService();
		List<Hotel_staff> list = new ArrayList<Hotel_staff>();
		System.out.println(phone);
		System.out.println(name);
		try {
			if(phone.equals("")){
				list = ss.queryByRelname(name);
				System.out.println("1");
			}else if(name.equals("")){
				list = ss.queryByPhone(phone);
				System.out.println("2");
			}else {
				list = ss.queryByPhoneAndName(phone, name);
				System.out.println("3");
			}

			map.put("result", true);
			map.put("data", list);

			
			
		} catch (SQLException e) {
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
