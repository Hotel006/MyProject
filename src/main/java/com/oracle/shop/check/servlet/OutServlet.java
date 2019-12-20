package com.oracle.shop.check.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracle.shop.check.service.OutService;
import com.oracle.util.AjaxResult;

/**
 * Servlet implementation class OutServlet
 */
public class OutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String r=request.getParameter("room");
		String room=r.split("/")[0];
		int state=Integer.valueOf(request.getParameter("state"));
		OutService outService =new OutService();
		AjaxResult result =new AjaxResult();
		if(state==0) {
			try {
				String text=request.getParameter("text");
				outService.clean(room,text);
			} catch (SQLException e) {
				result.setMsg(e.getMessage());
				result.setResult(false);
				e.printStackTrace();
			}
		}else {
			try {
				outService.out(room);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				result.setMsg(e.getMessage());
				result.setResult(false);
				e.printStackTrace();
			}
		}
		String json =JSON.toJSONString(result);
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
