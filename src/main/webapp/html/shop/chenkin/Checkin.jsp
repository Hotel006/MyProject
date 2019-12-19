<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>欢迎页面-L-admin1.0</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="../../../css/font.css">
<link rel="stylesheet" href="../../../css/xadmin.css">
<script src="../../../js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../../../lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="../../../js/xadmin.js"></script>
<%
	int state = Integer.valueOf(request.getParameter("state"));
	String room = request.getParameter("room");
	String rroom = room.split("/")[0];
%>
<title>入住</title>
</head>
<body class="form-wrap">

	<div class="layui-fluid">
		<div class="layui-card">
			<div class="layui-card-header">
				房间号为<%=room%>
			</div>
			<div class="layui-card-body" style="padding: 15px;">
				<form action="CheckServlet" method="post" id="ajaxForm">
					<div class="layui-form-item">
						<label class="layui-form-label">姓名：</label>
						<div class="layui-input-block">
							<input type="text" id="user_name" name="name" lay-verify="title"
								autocomplete="off" placeholder="请输入姓名" class="layui-input">
						
						</div>
					</div>
					
					<input type="hidden"  name="room" value="<%=room%>">

					<input type="hidden"  name="state" value="<%=state%>">
					
					<div class="layui-form-item">
						<label class="layui-form-label">手机号：</label>
						<div class="layui-input-block">
							<input type="tel" name="phone" id="user_phone" lay-verify="required|phone"
								autocomplete="off" placeholder="请输入手机号" class="layui-input">
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">身份证号：</label>
						<div class="layui-input-block">
							<input type="text" name="cardid" id="user_cardid" lay-verify="identity"
								placeholder="请输入身份证号" autocomplete="off" class="layui-input">
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">房间金额：</label>
						<div class="layui-input-block">
							<input type="text" id="user_money" name="money" autocomplete="off"
								class="layui-input">
						</div>

					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">入住天数：</label>
						<div class="layui-input-block">
							<input type="tel" id="u_day" name="day" autocomplete="off"
								class="layui-input">
						</div>
					</div>



					<div class="layui-form-item layui-layout-admin">
						<div class="layui-input-block">
							<div class="layui-footer" style="left: 0;">
								<button class="layui-btn" type="submit" >确认</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script>
		
	<%
	if (state == 0) {
      %>
		function add(name, phone, money, day) {
			$("#user_name").attr("value", name);
			$("#user_phone").attr("value", phone);
			$("#user_money").attr("value",money + "元/天");
			$("#u_day").attr("value",day + "天");
		}

		
		$(function() {
			$.ajax({
				url : "/Hotel/YudingServlet.do",
				context : document.body,
				data:{"datas":"<%=rroom%>","state":<%=state%> },
				dataType:"json",
				success : function(data) {
					$(data.datas).each(function(index,ele){
						var phone =ele.ophone;
						var name =ele.oname;
						var money =ele.rmoney;
						var day=ele.oday;
						add(name, phone, money,day);
					})
				}
			});
		})
		<%
	} else {
%>
function add(money) {
	$("#user_money").attr("value",money + "元/天");
}
$(function() {
	$.ajax({
		url :"/Hotel/YudingServlet.do",
		context : document.body,
		data:{"datas":"<%=rroom%>","state":<%=state%>},
		dataType:"json",
		success : function(data) {
			$(data.datas).each(function(index,ele){
				var money =ele.rmoney;
				console.log(money);
				add(money);
			})
		}
	});
})
<%
	}
%>
$(      //页面加载完执行
        $("#ajaxForm").on("submit",function () {    //表单提交时监听提交事件
        	$.ajax({
    			url :"/Hotel/CheckServlet.do",
    			context : document.body,
    			data:$('#ajaxForm').serialize(),
    			dataType:"json",
    			success : function(data) {
    				window.location.href="www.baidu.com";
    			}
    		});
            return false;   //  必须返回false，才能跳到想要的页面
        })
    )
	</script>


	
</body>
<style id="LAY_layadmin_theme">.layui-side-menu,.layadmin-pagetabs .layui-tab-title li:after,.layadmin-pagetabs .layui-tab-title li.layui-this:after,.layui-layer-admin .layui-layer-title,.layadmin-side-shrink .layui-side-menu .layui-nav>.layui-nav-item>.layui-nav-child{background-color:#20222A !important;}.layui-nav-tree .layui-this,.layui-nav-tree .layui-this>a,.layui-nav-tree .layui-nav-child dd.layui-this,.layui-nav-tree .layui-nav-child dd.layui-this a{background-color:#009688 !important;}.layui-layout-admin .layui-logo{background-color:#20222A !important;}</style>


</html>