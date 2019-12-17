<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>入住</title>
<%
	int state = Integer.valueOf(request.getParameter("state"));
	String room = request.getParameter("room");
	String rroom = room.split("/")[0];
%>
	</head>
<body>
<body class="form-wrap">

	<div class="layui-fluid">
		<div class="layui-card">
			<div class="layui-card-header">
				房间号为<%=room %></div>
			<div class="layui-card-body" style="padding: 15px;">
				<form class="layui-form" action="" lay-filter="component-form-group">
					<div class="layui-form-item">
						<label class="layui-form-label">姓名：</label>
						<div class="layui-input-block">
							<input id="user_name" type="text" name="title" lay-verify="title"
								autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">身份证号：</label>
						<div class="layui-input-block">
							<input id="user_cardid" type="text" name="username"
								lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">手机号：</label>
						<div class="layui-input-block">
							<input id="user_phone" type="tel" name="phone"
								lay-verify="required|phone" autocomplete="off"
								class="layui-input">
						</div>
					</div>


					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">金额</label> <label
								class="layui-form-label" id="user_money">￥xxxx元</label>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">入住天数</label>
							<div class="layui-input-inline">
								<select id="user_day" name="modules" lay-verify="required"
									lay-search="">
									<option value="">直接选择或搜索选择</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
								</select>
								<div class="layui-form-select">
									<div class="layui-select-title">
										<input type="text" placeholder="直接选择或搜索选择" value=""
											class="layui-input"><i class="layui-edge"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">其他要求</label>
						<div class="layui-input-block">
							<textarea name="text" placeholder="请输入内容" class="layui-textarea"></textarea>
						</div>
					</div>
					<div class="layui-form-item layui-layout-admin">
						<div class="layui-input-block">
							<div class="layui-footer" style="left: 0;">
								<button class="layui-btn" lay-submit=""
									lay-filter="component-form-demo1">立即提交</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%if(state==0){ %>
	<script type="text/javascript">
	function add(name, phone, money) {
		console.log(name);
		console.log(phone);
		console.log(money);
		$("#user_name").attr("value", name);
		$("#user_phone").attr("value", phone);
		$("#user_money").text(money+"元");
	}
	$(function() {
		$.ajax({
			url : "/Hotel/YudingServlet.do",
			context : document.body,
			data:{"datas":"<%=rroom%>","state":<%=state%>},
			dataType:"json",
			success : function(data) {
				$(data.datas).each(function(index,ele){
					var phone =ele.ophone;
					var name =ele.oname;
					var money =ele.rmoney;
					add(name, phone, money);
				})
			}
		});
	})

</script>
<%} else {%>
<script type="text/javascript">
	function add(money) {
		$("#user_money").text(money+"元");
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
					add(money);
				})
			}
		});
	})
	</script>
	<% }%>


</body>
</html>