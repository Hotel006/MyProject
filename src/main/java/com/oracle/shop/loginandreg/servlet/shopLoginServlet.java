package com.oracle.shop.loginandreg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.entity.Hotel_admin;
import com.oracle.shop.loginandreg.service.LoginService;

/**
 * Servlet implementation class LoginRegServlet
 */
public class shopLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginname = request.getParameter("loginname");
		String loginpass = request.getParameter("loginpass");
		LoginService ls = new LoginService();
		try {
			Hotel_admin ha  = ls.login(loginname, loginpass);
			
			request.getSession().setAttribute("SESSIONUSER", ha);
			request.getRequestDispatcher("/").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
