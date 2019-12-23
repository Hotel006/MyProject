package com.oracle.shop.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.oracle.entity.Hotel_order;
import com.oracle.util.DBHelper;

public class HotelOrderDao extends DBHelper{
	
	QueryRunner q = new QueryRunner(DBHelper.ds);

	public List<Hotel_order> queryAll() throws SQLException {
	
		String sql="select * from hotel_order";
		List<Hotel_order> list = q.query(sql,new BeanListHandler<Hotel_order>(Hotel_order.class));	
		System.out.println(list);
		return list;
	}
	
//	public List<Hotel_order> queryTerm(String onumber,String ophone,String ohouse,String osource) throws SQLException {
//		
//		String sql = "SELECT*FROM hotel_order WHERE onumber=? AND ophone=? AND ohouse=? AND osource=?";
//		List<Hotel_order> list = q.query(sql, new BeanListHandler<Hotel_order>(Hotel_order.class));
//		return list;
//	}
	
	public List<Hotel_order> queryTrem(Hotel_order ho, int page) {
        
        List<Hotel_order>list=new ArrayList<Hotel_order>();
        List<Object>pramaters=new ArrayList<Object>();
        String sql="select * from hotel_order where 1=1";
        
        if(ho.getOnumber()!=null){
            sql+=" and onumber=?";
            pramaters.add(ho.getOnumber());
        }
        if(ho.getOphone()!=null){
            sql+=" and ophone=?";
            pramaters.add(ho.getOphone());
        }
        if(ho.getOhouse()!=null){
            sql+=" and ohouse=?";
            pramaters.add(ho.getOhouse());
        }
        if(ho.getOsource()!=null){
             sql+=" and osource=?";
             pramaters.add(ho.getOsource());
        }
        int index=(page-1)*10;
        sql+=" limit ?,10"; 
         pramaters.add(index);
         System.out.println(sql);
        //2.获取数据库 连接对象
         DBHelper con=DBHelper.getInstance();
        //3.获取预编译对象
         PreparedStatement st=null;//预编译语句对象
         ResultSet rs=null;//结果集
         try {
            st=((Connection) con).prepareStatement(sql);
         //4.给预编译对象占位符进行赋值
            for (int i = 0; i <pramaters.size(); i++) {
                //按对象给他们赋值
                st.setObject(i+1,pramaters.get(i));
            }
        
        //5.执行预编译语句
            rs=st.executeQuery();
           //遍历结果集
           while(rs.next()){
            //初始化一个mode对象
              Hotel_order mode=new Hotel_order();
              mode.setOnumber(rs.getString("onumber")); 
              mode.setOname(rs.getString("oname"));
              mode.setOphone(rs.getString("ophone"));
              mode.setOroom(rs.getString("oroom"));
              mode.setOhouse(rs.getString("ohouse"));
              mode.setOcount(rs.getString("ocount"));
              mode.setOmoney(rs.getString("omoney"));
              mode.setOydontime(rs.getDate("oydontime"));
              mode.setOday(rs.getString("oday"));
              mode.setOontime(rs.getDate("oontime"));
              mode.setOyjouttime(rs.getDate("oyjouttime"));
              mode.setOouttime(rs.getDate("oouttime"));
              mode.setOoderstate(rs.getString("ooderstate"));
              mode.setOsource(rs.getString("osource"));
              mode.setOcard(rs.getString("ocard"));
              list.add(mode);   
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        return list;
    }

    public int queryTrem1(Hotel_order stu) {
        String sql="select count(*) as c from hotel_order where 1=1";
        List<Object>pramaters=new ArrayList<Object>();
        if(stu.getOnumber()!=null){
            sql+=" and onumber=?";//每次加等的时候都需要加一个空格
            pramaters.add(stu.getOnumber());
        }
        if(stu.getOphone()!=null){
            sql+=" and ophone=?";
            pramaters.add(stu.getOphone());
        }
        if(stu.getOhouse()!=null){
            sql+=" and ohouse=?";
            pramaters.add(stu.getOhouse());
        }
        if(stu.getOsource()!=null){
             sql+=" and osource=?";
             pramaters.add(stu.getOsource());
        }
        //2.获取数据库连接对象
                DBHelper con=DBHelper.getInstance();
                //3.获取预编译对象
                PreparedStatement st=null;
                ResultSet rs=null;
                int count=0;
                try {
                     //4.给预编译对象占位符进行赋值
                    st=((Connection) con).prepareStatement(sql);
                    for (int i = 0; i <pramaters.size(); i++) {
                        //按对象给他们赋值
                        st.setObject(i+1,pramaters.get(i));
                    }
                    rs=st.executeQuery();
                    while(rs.next()){
                        //1.通过列下表获取元素 
                        count=rs.getInt("c");
                        System.out.println(count);
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
                return count;
    } 
}

	

