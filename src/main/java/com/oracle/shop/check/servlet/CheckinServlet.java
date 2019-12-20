package com.oracle.shop.check.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.StringHolder;

import com.alibaba.fastjson.JSON;
import com.oracle.shop.check.service.YudingandCheckService;
import com.oracle.util.AjaxResult;

/**
 * Servlet implementation class CheckinServlet
 */
public class CheckinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		YudingandCheckService yService =new YudingandCheckService();
		String name=request.getParameter("name");
		String cardid=request.getParameter("cardid");
		String phone=request.getParameter("phone");
		String m =request.getParameter("money");
		String d =request.getParameter("day");
		int state =Integer.valueOf(request.getParameter("state"));
		String money=m.split("元")[0];
		String day =d.split("天")[0];
		AjaxResult result =new AjaxResult();
		if(state==1) {
			String room=request.getParameter("room");
			try {
				yService.ruzhu(name,cardid,phone,d,money,room);
			} catch (Exception e) {
				result.setResult(false);
				result.setMsg(e.getMessage());
				e.printStackTrace();
			}
		}else if (state==3) {
			String room=request.getParameter("room");
			String souce=request.getParameter("souce");
			String time =request.getParameter("date");
			try {
				System.out.println(d);
				System.out.println(money);
				System.out.println(room);
				System.out.println(souce);
				System.out.println(time);
				yService.reserve(name,phone,d,money,room,souce,time);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				result.setMsg(e.getMessage());
				result.setResult(false);
				e.printStackTrace();
			}
		}else{
			try {
				yService.yuding(name,cardid,phone,day,money);
			} catch (Exception e) {
				result.setMsg(e.getMessage());
				result.setResult(false);
				e.printStackTrace();
			}
		}
		
		String json =JSON.toJSONString(result);
		System.out.println(json);
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
