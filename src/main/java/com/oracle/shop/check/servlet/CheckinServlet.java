package com.oracle.shop.check.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.StringHolder;

import com.oracle.shop.check.service.YudingService;
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
		YudingService yService =new YudingService();
		String name=request.getParameter("name");
		String cardid=request.getParameter("cardid");
		String phone=request.getParameter("phone");
		String m =request.getParameter("money");
		String d =request.getParameter("day");
		int state =Integer.valueOf(request.getParameter("state"));
		String money=m.split("元")[0];
		String day =d.split("天")[0];
		if(state==1) {
			String room=request.getParameter("room");
			try {
				System.out.println("开始");
				yService.ruzhu(name,cardid,phone,d,money,room);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				yService.yuding(name,cardid,phone,day,money);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
