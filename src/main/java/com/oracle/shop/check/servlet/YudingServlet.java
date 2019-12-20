package com.oracle.shop.check.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracle.entity.Hotel_order;
import com.oracle.shop.check.service.YudingandCheckService;
import com.oracle.util.AjaxResult;

/**
 * Servlet implementation class YudingServlet
 */
public class YudingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YudingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		AjaxResult a =new AjaxResult();
		String room=request.getParameter("datas");
		int state=Integer.valueOf(request.getParameter("state"));
		YudingandCheckService yc=new YudingandCheckService();
		if(state==0) {
			try {
				List<Hotel_order> list=yc.showroom(room);
				a.setDatas(list);
				System.out.println("那就是这里");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				a.setMsg(e.getMessage());
				a.setResult(false);
				e.printStackTrace();
			}
		}else if(state==2){
			String oroom =request.getParameter("room");
			String stroom=oroom.split("/")[0];
			try {
				yc.removeyuding(stroom);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				a.setMsg(e.getMessage());
				a.setResult(false);
				e.printStackTrace();
			}
		}else{
			try {
				List<Hotel_order> list=yc.showcheck(room);
			System.out.println("这里");
			a.setDatas(list);
			} catch (SQLException e) {
				a.setMsg(e.getMessage());
				a.setResult(false);
				e.printStackTrace();
			}
		}
		String json=JSON.toJSONString(a);
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
