		function showTime(){
		var t =new Date();
		var year =t.getFullYear();//年
		var month=t.getMonth();//月
		var day =t.getDate();//日
		var week=t.getDay();//星期
		var arr=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
		var hour =t.getHours();
		var min=t.getMinutes();
		var second=t.getSeconds();
		var showTime=year+'/'+month+'/'+day+' '+arr[week]+' '+hour+((min<10)?":0":":")+min+((second<10)?":0":":")+second;
		console.log(showTime);
		document.getElementById('#clock').value=showTime;
		}
		$(function(){
			setInterval(showTime,1000);
		});