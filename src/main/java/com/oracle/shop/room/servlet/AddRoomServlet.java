package com.oracle.shop.room.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.entity.Hotel_room;
import com.oracle.shop.room.service.AddRoomService;

/**
 * Servlet implementation class AddRoomServlet
 */
public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//取值
		String rhouse = request.getParameter("yourname");
		String rnumber =request.getParameter("youphone");
		String rmoney  = request.getParameter("youziz");
		String rbrief = request.getParameter("description");
		String rimg  = request.getParameter("path");
		
		System.out.println(rhouse);
		//调用
		AddRoomService as = new AddRoomService();
		Hotel_room hr = new Hotel_room();
		hr.setRhouse(rhouse);
		hr.setRnumber(rnumber);
		hr.setRmoney(rmoney);
		hr.setRbrief(rbrief);
		hr.setRimg(rimg);
		
		try {
			as.add(hr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}















