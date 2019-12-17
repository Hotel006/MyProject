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
import com.oracle.shop.check.service.QueryService;
import com.oracle.util.AjaxResult;

/**
 * Servlet implementation class QueryyudingServlet
 */
public class QueryyudingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryyudingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AjaxResult result = new AjaxResult();
		QueryService qService =new QueryService();
		try {
			List<Hotel_order> list =qService.queryyuding();
			result.setDatas(list);
		} catch (SQLException e) {
			result.setResult(false);
			result.setMsg(e.getMessage());
			e.printStackTrace();
		}
		String json=JSON.toJSONString(result);
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
