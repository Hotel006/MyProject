package com.oracle.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

public class SMGutil {
	
	public void sendValidateCode(String phoneNO,String validateCode) {
		
		 String host = "http://dingxin.market.alicloudapi.com";
		    String path = "/dx/sendSms";
		    String method = "POST";
		    String appcode = "0360bec0484347ee95129f1b1228b05b";
		    Map<String, String> headers = new HashMap<String, String>();
		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		    headers.put("Authorization", "APPCODE " + appcode);
		    Map<String, String> querys = new HashMap<String, String>();
		    querys.put("mobile",phoneNO);
		    querys.put("param", "code:"+validateCode+"");
		    querys.put("tpl_id", "TP19120918");
		    Map<String, String> bodys = new HashMap<String, String>();


		    try {
		    	/**
		    	* 重要提示如下:
		    	* HttpUtils请从
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
		    	* 下载
		    	*
		    	* 相应的依赖请参照
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
		    	*/
		    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
		    	System.out.println(response.toString());
		    	//获取response的body
		    	//System.out.println(EntityUtils.toString(response.getEntity()));
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
	}
	
	   

}
