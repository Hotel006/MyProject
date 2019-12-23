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
	String time=request.getParameter("time");
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
<!-- 						<video id="video" width="20" height="10" autoplay></video>
						<button class="layui-btn" id="snap">拍摄</button>
							<canvas id="canvas" width="20" height="10"></canvas> -->
						</div>
					</div>
					<%if(state!=3){ %>

					<div class="layui-form-item">
						<label class="layui-form-label">身份证号：</label>
						<div class="layui-input-block">
							<input type="text" name="cardid" id="user_cardid" lay-verify="identity"
								placeholder="请输入身份证号" autocomplete="off" class="layui-input">
						</div>
					</div>
					
				
				
					<%} %>

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
					<%if(state==3){ %>
					<div class="layui-form-item">
						<label class="layui-form-label">订单来源：</label>
						<div class="layui-input-block">
							<input type="tel" id="user_souce" name="souce" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					
						<input type="hidden"  name="date" value="<%=time  %>">
					<%} %>
					
					<%if(state==5){ %>
			<div class="layui-card-body layui-row layui-col-space10">
            	<div class="layui-col-md12">
              		<select name="house" lay-verify="">
                	<option value="" id='addroom'>请选择一个房间</option>
              </select>
            </div>
          </div>
          <script type="text/javascript">
          $(function() {
        	  var html='';
				$.getJSON("/Hotel/QueryRoomServlet.do", function(json) {
					$(json.datas).each(function(index, ele) {
						var room=ele.rnumber;
						var type=ele.rhouse;
						var t =room+"/"+type;
					   html+="<option value="+t+">"+t+"</option>" ;
					})
					$("#addroom").after(html);
					
  		})
          </script>
					
					<%} %>



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
    				if(data.result==true){
        				layer.confirm('入住/预定成功', {
        					  btn: ['确认'] //按钮
        					}, function(){
        					  layer.msg('返回主页面', {icon: 1});
        					  setTimeout(reload,1000);
        					  parent.layer.closeAll();
        					});
    				}else{
        				layer.confirm(data.msg, {
        					  btn: ['确认'] //按钮
        					}, function(){
        					  layer.msg(data.msg, {icon: 2});
        					 setTimeout(reload,1000);
        					  parent.layer.closeAll();
        					});
    				}
    				
    				
    			}
    		});
            return false;   //  必须返回false，才能跳到想要的页面
        })
    )
    
    function reload() {
				window.parent.location.reload();
			}
	</script>


	
</body>
<style id="LAY_layadmin_theme">.layui-side-menu,.layadmin-pagetabs .layui-tab-title li:after,.layadmin-pagetabs .layui-tab-title li.layui-this:after,.layui-layer-admin .layui-layer-title,.layadmin-side-shrink .layui-side-menu .layui-nav>.layui-nav-item>.layui-nav-child{background-color:#20222A !important;}.layui-nav-tree .layui-this,.layui-nav-tree .layui-this>a,.layui-nav-tree .layui-nav-child dd.layui-this,.layui-nav-tree .layui-nav-child dd.layui-this a{background-color:#009688 !important;}.layui-layout-admin .layui-logo{background-color:#20222A !important;}</style>

<script>
    window.addEventListener("DOMContentLoaded", function() {
        var canvas = document.getElementById("canvas"),//调用canvas接口
                context = canvas.getContext("2d"),
                video = document.getElementById("video"),
                videoObj = { "video": true },
                errBack = function(error) {//错误处理
                    console.log("Video capture error: ", error.code);
                };
        if(navigator.getUserMedia) {//调用html5拍摄接口
            navigator.getUserMedia(videoObj, function(stream) {
                video.src = stream;//摄像机属于视频流，所以当然要输出到html5的video标签中了
                video.play();//开始播放
            }, errBack);
        } else if(navigator.webkitGetUserMedia) { //WebKit内核调用html5拍摄接口
            navigator.webkitGetUserMedia(videoObj, function(stream){
                video.src = window.webkitURL.createObjectURL(stream);//同上
                video.play();//同上
            }, errBack);
        }
        else if(navigator.mozGetUserMedia) { //moz内核调用html5拍摄接口
            navigator.mozGetUserMedia(videoObj, function(stream){
                video.src = window.URL.createObjectURL(stream);//同上
                video.play();//同上
            }, errBack);
        }
    }, false);

    document.getElementById("snap")
            .addEventListener("click", function() {//获取拍照按钮绑定事件
                var canvans = document.getElementById("canvas"),//调用canvas接口
                        context = canvas.getContext("2d");
                context.drawImage(video, 0, 0, 640, 480);//调用canvas接口的drawImage方法绘制当前video标签中的静态图片，其实就是截图

                var imgData = canvans.toDataURL();//获取图片的base64格式的数据
                //这里就可以写上传服务器代码了
                	$.ajax({
    			url :"/Hotel/PhotoServlet.do",
    			context : document.body,
    			data:("img",imgData),
    			dataType:"json",
    			success : function(data) {
    				
    			});
            });
</script>




</html>