package com.oracle.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.oracle.util.DBHelper;

/**
 * Application Lifecycle Listener implementation class ServerStartListener
 *
 */
public class ServerStartListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServerStartListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("============连接池开启==================");
				 //初始化数据库连接池
		    	DBHelper.getInstance();
				System.out.println("===========234===================");

			}
		}).start();
    }
	
}
