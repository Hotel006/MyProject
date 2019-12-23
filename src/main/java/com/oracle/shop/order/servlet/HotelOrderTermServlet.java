package com.oracle.shop.order.servlet;

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
import com.oracle.entity.Hotel_order;
import com.oracle.entity.Hotel_staff;
import com.oracle.shop.order.dao.HotelOrderDao;
import com.oracle.shop.order.service.HotelOrderService;
import com.oracle.shop.staff.service.StaffService;

/**
 * Servlet implementation class HotelOrderTermServlet
 */
public class HotelOrderTermServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelOrderTermServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
//		String ohouse = request.getParameter("ohouse");
//		String osource = request.getParameter("osource");
//		String ophone = request.getParameter("ophone");
//		String onumber = request.getParameter("onumber");
//		Map<String,Object> map = new HashMap<String,Object>();
//		HotelOrderTermService hots = new HotelOrderTermService();
//		List<Hotel_order> list = new ArrayList<Hotel_order>();
//		try {
//			if(ohouse==null && osource==null && ophone==null && onumber==null) {
//			map.put("msg", "请输入查询条件进行查询");
//			
//			response.getWriter().print(JSON.toJSONString(map));
//		
//			}else{
//				list = hots.queryTerm(osource,osource,ophone,onumber);
//			}
//			
//			map.put("result", true);
//			map.put("data", list);
//			
//			response.getWriter().print(JSON.toJSONString(map));
//			
//		} catch (SQLException e) {
//				map.put("result", false);
//				map.put("msg", e.getMessage());
//		}
		
		
		
		//1.获取前端发送过来的数据
         Hotel_order ho = new Hotel_order();
        int page=Integer.parseInt(request.getParameter("page")); //分页
        String ohouse=request.getParameter("ohouse");
        //获取相应的字段
        String osource=request.getParameter("osource");
        String ophone=request.getParameter("ophone");
        String onumber=request.getParameter("onumber");
        //设置属性的值
        if(onumber.length()==0)ho.setOnumber(null);
        else ho.setOnumber(onumber);
        if(ophone.length()==0)ho.setOphone(null);
        else ho.setOphone(ophone);
        if(ohouse.length()==0)ho.setOhouse(null);
        else ho.setOhouse(ohouse);
        if(osource.length()==0)ho.setOsource(null);
        else ho.setOsource(osource);
   //2.处理数据
        HotelOrderDao dao=new HotelOrderDao();
        List<Hotel_order>list=dao.queryTrem(ho,page);//查询分页
        int count=dao.queryTrem1(ho);
        int countPage= count%10==0?count/10:count/10+1;//总页数
        System.out.println(countPage);
       /* 
        {
         countPage:20;
         data:[] 
        }
        */
        HashMap<String,Object>map=new HashMap<String, Object>();
        map.put("countpage", countPage);
        map.put("data",list);
        System.out.println(list);
        
   //3.响应数据        
        //响应头的相关设置
        response.setContentType("text/html;charset=utf-8");
        //将数据转换成json字符串
        response.getWriter().println(JSON.toJSONString(map));
       } 
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
