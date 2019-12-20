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
		
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		Map<String,Object> map = new HashMap<String,Object>();
		StaffService ss = new StaffService();
		List<Hotel_staff> list = new ArrayList<Hotel_staff>();
		try {
			if(phone==null && name==null) {
			map.put("msg", "请输入查询条件进行查询");
			
			response.getWriter().print(JSON.toJSONString(map));

				
			}else if(phone==null){
				list = ss.queryByRelname(name);
				
			}else if(name==null){
				list = ss.queryByPhone(phone);
			}else {
				list = ss.queryByPhoneAndName(phone, name);
			}
			
			map.put("result", true);
			map.put("data", list);
			
			
			response.getWriter().print(JSON.toJSONString(map));
			
		} catch (SQLException e) {
				map.put("result", false);
				map.put("msg", e.getMessage());
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
