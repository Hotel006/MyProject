package com.oracle.shop.room.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSONObject;
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
		//设置编码为utf-8
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				FileItemFactory factory = new DiskFileItemFactory();
				Map<String, Object> map = new HashMap<String, Object>();
		
		//取值
		String rhouse = request.getParameter("yourname");
		String rnumber =request.getParameter("youphone");
		String rmoney  = request.getParameter("youziz");
		String rbrief = request.getParameter("description");
		String rimg  = request.getParameter("path");
		
		/*
		 * // 文件上传处理器 ServletFileUpload upload = new ServletFileUpload(factory); //
		 * 解析请求信息 List items = null; try { items = upload.parseRequest(request); } catch
		 * (FileUploadException e) { e.printStackTrace(); } // 对请求信息进行判断 Iterator iter =
		 * items.iterator(); while (iter.hasNext()) { FileItem item = (FileItem)
		 * iter.next(); // 信息为普通的格式 if (item.isFormField()) { String fieldName =
		 * item.getFieldName(); String value = item.getString();
		 * request.setAttribute(fieldName, value); } // 信息为文件格式 else { String fileName =
		 * item.getName();//获得上传图片的名称 int index = fileName.lastIndexOf("\\"); fileName =
		 * fileName.substring(index + 1); request.setAttribute("realFileName",
		 * fileName); String basePath =
		 * request.getSession().getServletContext().getRealPath("/images");
		 * System.out.println(basePath);//打印当前位置 File file = new File(basePath,
		 * fileName); try {
		 * 
		 * item.write(file); } catch (Exception e) { e.printStackTrace(); } }
		 * 
		 * }
		 */


		System.out.println(rhouse);
		System.out.println(rnumber);
		System.out.println(rmoney);
		System.out.println(rbrief);
		System.out.println(rimg);
		//调用
		AddRoomService as = new AddRoomService();
		Hotel_room hr = new Hotel_room();
		hr.setRhouse(rhouse);
		hr.setRnumber(rnumber);
		hr.setRmoney(rmoney);
		hr.setRbrief(rbrief);
		hr.setRimg(rimg);
		hr.setRstatus(0);
		
		try {
			as.add(hr);
			map.put("result", true);
		} catch (SQLException e) {
			map.put("result", false);
			map.put("msg", e.getMessage());
		}
		
		
		response.getWriter().print(JSONObject.toJSONString(map));
		
		
	}

}















