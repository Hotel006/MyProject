package com.oracle.shop.staff.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracle.entity.Hotel_staff;
import com.oracle.shop.staff.dao.StaffDao;
import com.oracle.shop.staff.service.StaffService;
import com.oracle.util.DateUtil;

/**
 * Servlet implementation class AddStaffServlet
 */
public class AddStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStaffServlet() {
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
		String relname = request.getParameter("relname");
		String sex =  request.getParameter("sex");
		String age =   request.getParameter("age");
		String birthday =  request.getParameter("birthday");
		String phone =  request.getParameter("phone");
		String username =  request.getParameter("username");
		String userpass =  request.getParameter("userpass");
		
		
		
		try {
			StaffService ss = new StaffService();
			Hotel_staff stf = ss.queryByUsername(username);
			
			if(stf!=null) {
				throw new RuntimeException("此员工账号已经注册，请更换账号进行注册");
			}
			Hotel_staff st = new Hotel_staff();
			st.setSname(relname);
			st.setSphone(phone);
			st.setSage(Integer.parseInt(age));
			st.setSbirthday(DateUtil.stringtodate(birthday, DateUtil.D));
			st.setSentername(username);
			st.setSenterpass(userpass);
			st.setSsex(sex);

			ss.save(st);
			
			
			
			map.put("result", true);
			
			
			
		} catch (Exception e) {
			map.put("msg",e.getMessage());
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
