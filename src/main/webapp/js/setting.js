// Custom scripts
$(document).ready(function() {
    function markPage() {
        if ($(".js-ignore-pagemark").length != 0) return;
        var markNavItem = function(item) {
            item.addClass('active');
        }
        var $nav = $('.sidebar-collapse .nav'),
            i = 0,
            anchor;
        if ($nav.length != 0) {
            $nav.find("li").each(function() {
                anchor = $(this).find("a");
                if (window.location.href.indexOf(anchor.attr("href")) != -1 && anchor.attr("href") != "/") {
                    markNavItem($(this));
                    i = 1;
                }
            });
            if (i === 0) {
                markNavItem($nav.find("li").eq(1));
            }
        }
    };
    markPage();

    function fixHeight() {
        var height = $( window ).height();
        $("#page-wrapper").css("min-height", height + 'px');
    }

    $(window).bind("load resize click scroll", function() {
        fixHeight();
    })
	///////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////
	//报表数据提取//////////////////////////////////////////////////////////////////////////////////////////////
	getXMZT();
	$("#zqzr").hide();
	$("#xmzt_a").click(function(){
		$("#xmzt").show();
		$("#zqzr").hide();
		getXMZT();
	});
	$("#zqzr_a").click(function(){
		$("#xmzt").hide();
		$("#zqzr").show();
		getZQZR();
	});
	//保障方式分布
	getBZFSFB();
	//融资期限分布
	getRZQXFB();
	//产品类型分布 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
	getCPLXFB();
	//融资主体行业分布 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
	getRZZTHYFB();
	
	//平台保证金变化 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
	getPTBZJBH();
	//投资人年龄/性别分布 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
	getTZRNL_XBFB();
	//投资额渠道分布 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
	getTZEQDFB();
	reportMap();
});
function reportMap(){
	 var myChart = echarts.init(document.getElementById('report_map'));
option = {
    title : {
        text: 'iphone销量',
        subtext: '纯属虚构',
        x:'center'
    },
    tooltip : {
        trigger: 'item'
    },
    legend: {
        orient: 'vertical',
        x:'left',
        data:['iphone3','iphone4','iphone5']
    },
    dataRange: {
        min: 0,
        max: 2500,
        x: 'left',
        y: 'bottom',
        text:['高','低'],           // 文本，默认为数值文本
        calculable : true
    },
    toolbox: {
        show: true,
        orient : 'vertical',
        x: 'right',
        y: 'center',
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    roamController: {
        show: true,
        x: 'right',
        mapTypeControl: {
            'china': true
        }
    },
    series : [
        {
            name: 'iphone3',
            type: 'map',
            mapType: 'china',
            roam: false,
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{label:{show:true}}
            },
            data:[
                {name: '北京',value: Math.round(Math.random()*1000)},
                {name: '天津',value: Math.round(Math.random()*1000)},
                {name: '上海',value: Math.round(Math.random()*1000)},
                {name: '重庆',value: Math.round(Math.random()*1000)},
                {name: '河北',value: Math.round(Math.random()*1000)},
                {name: '河南',value: Math.round(Math.random()*1000)},
                {name: '云南',value: Math.round(Math.random()*1000)},
                {name: '辽宁',value: Math.round(Math.random()*1000)},
                {name: '黑龙江',value: Math.round(Math.random()*1000)},
                {name: '湖南',value: Math.round(Math.random()*1000)},
                {name: '安徽',value: Math.round(Math.random()*1000)},
                {name: '山东',value: Math.round(Math.random()*1000)},
                {name: '新疆',value: Math.round(Math.random()*1000)},
                {name: '江苏',value: Math.round(Math.random()*1000)},
                {name: '浙江',value: Math.round(Math.random()*1000)},
                {name: '江西',value: Math.round(Math.random()*1000)},
                {name: '湖北',value: Math.round(Math.random()*1000)},
                {name: '广西',value: Math.round(Math.random()*1000)},
                {name: '甘肃',value: Math.round(Math.random()*1000)},
                {name: '山西',value: Math.round(Math.random()*1000)},
                {name: '内蒙古',value: Math.round(Math.random()*1000)},
                {name: '陕西',value: Math.round(Math.random()*1000)},
                {name: '吉林',value: Math.round(Math.random()*1000)},
                {name: '福建',value: Math.round(Math.random()*1000)},
                {name: '贵州',value: Math.round(Math.random()*1000)},
                {name: '广东',value: Math.round(Math.random()*1000)},
                {name: '青海',value: Math.round(Math.random()*1000)},
                {name: '西藏',value: Math.round(Math.random()*1000)},
                {name: '四川',value: Math.round(Math.random()*1000)},
                {name: '宁夏',value: Math.round(Math.random()*1000)},
                {name: '海南',value: Math.round(Math.random()*1000)},
                {name: '台湾',value: Math.round(Math.random()*1000)},
                {name: '香港',value: Math.round(Math.random()*1000)},
                {name: '澳门',value: Math.round(Math.random()*1000)}
            ]
        },
        {
            name: 'iphone4',
            type: 'map',
            mapType: 'china',
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{label:{show:true}}
            },
            data:[
                {name: '北京',value: Math.round(Math.random()*1000)},
                {name: '天津',value: Math.round(Math.random()*1000)},
                {name: '上海',value: Math.round(Math.random()*1000)},
                {name: '重庆',value: Math.round(Math.random()*1000)},
                {name: '河北',value: Math.round(Math.random()*1000)},
                {name: '安徽',value: Math.round(Math.random()*1000)},
                {name: '新疆',value: Math.round(Math.random()*1000)},
                {name: '浙江',value: Math.round(Math.random()*1000)},
                {name: '江西',value: Math.round(Math.random()*1000)},
                {name: '山西',value: Math.round(Math.random()*1000)},
                {name: '内蒙古',value: Math.round(Math.random()*1000)},
                {name: '吉林',value: Math.round(Math.random()*1000)},
                {name: '福建',value: Math.round(Math.random()*1000)},
                {name: '广东',value: Math.round(Math.random()*1000)},
                {name: '西藏',value: Math.round(Math.random()*1000)},
                {name: '四川',value: Math.round(Math.random()*1000)},
                {name: '宁夏',value: Math.round(Math.random()*1000)},
                {name: '香港',value: Math.round(Math.random()*1000)},
                {name: '澳门',value: Math.round(Math.random()*1000)}
            ]
        },
        {
            name: 'iphone5',
            type: 'map',
            mapType: 'china',
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{label:{show:true}}
            },
            data:[
                {name: '北京',value: Math.round(Math.random()*1000)},
                {name: '天津',value: Math.round(Math.random()*1000)},
                {name: '上海',value: Math.round(Math.random()*1000)},
                {name: '广东',value: Math.round(Math.random()*1000)},
                {name: '台湾',value: Math.round(Math.random()*1000)},
                {name: '香港',value: Math.round(Math.random()*1000)},
                {name: '澳门',value: Math.round(Math.random()*1000)}
            ]
        }
    ]
};
                    
                    
        myChart.setOption(option);
}
//项目直投 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
function getXMZT(){
	var xiangmuzhitou_data = {
		labels : ["2014-02","2014-03","2014-04","2014-05","2014-06","2014-07","2014-08","2014-09","2014-10","2014-11","2014-12","2015-01","2015-02","2015-03","2015-04","2015-05","2015-06"],
		datasets : [
			{
				fillColor : "rgba(79,193,233,1)",//柱状填充颜色
				strokeColor : "rgba(79,193,233,1)",//柱状边框颜色
				data : [5589600.00,134102800.00,26581300.00,46781200.00,78425531.88,80201040.04,65180000.00,152670000.00,333104297.337,242344872.50,344487352.12,593190209.44,712057160.88,523722747.29,724324162.13,680328851.34,903933015.84]
			}
		]
	}
	var defaults = {
		// 刻度是否显示标签, 即Y轴上是否显示文字
		scaleShowLabels : true,
		// Y轴上的刻度,即文字
		scaleLabel : "<%=value/100000000%>元",
		// 文字大小
		scaleFontSize : 14,
	}
	var xiangmuzhitou_ctx = document.getElementById("xiangmuzhitou").getContext("2d");
	var xiangmuzhitou = new Chart(xiangmuzhitou_ctx).Bar(xiangmuzhitou_data,defaults);
}
//债权转让 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
function getZQZR(){
	var zhaiquanzhuanrang_data = {
		labels : ["2014-03","2014-04","2014-05","2014-06","2014-07","2014-08","2014-09","2014-10","2014-11","2014-12","2015-01","2015-02","2015-03","2015-04","2015-05","2015-06","2015-07"],
		datasets : [
			{
				fillColor : "rgba(79,193,233,1)",//柱状填充颜色
				strokeColor : "rgba(79,193,233,1)",//柱状边框颜色
				data : [5589600.00,14102800.00,26581300.00,46781200.00,78425531.88,80201040.04,65180000.00,152670000.00,333104297.37,242344872.50,344487352.12,593190209.44,712057160.88,523722747.29,724324162.13,680328851.34,5933015.84]
			}
		]
	}
	var defaults = {
		// 刻度是否显示标签, 即Y轴上是否显示文字
		scaleShowLabels : true,
		// Y轴上的刻度,即文字
		scaleLabel : "<%=value/100000000%>亿",
		// 文字大小
		scaleFontSize : 14,
	}
	var zhaiquanzhuanrang_ctx = document.getElementById("zhaiquanzhuanrang").getContext("2d");
	var zhaiquanzhuanrang = new Chart(zhaiquanzhuanrang_ctx).Bar(zhaiquanzhuanrang_data,defaults);
}
//保障方式分布 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
function getBZFSFB(){
	var baozhangfangshifenbu_data = [
	{
		value: 30,
		color:"#4FC1E9"
	},
	{
		value : 50,
		color : "#F89135"
	},
	{
		value : 100,
		color : "#F8585B"
	},
	{
		value : 40,
		color : "#FFDC89"
	},
	{
		value : 120,
		color : "#66CC66"
	},
	{
		value : 120,
		color : "#596373"
	}]
	var defaults = {
    // 块和块之间是否有间距
	segmentShowStroke : true,
	// 块和块之间间距的颜色
	segmentStrokeColor : "#fff",
	// 块和块之间间距的宽度
    segmentStrokeWidth : 1,
    // 是否有动画效果	
	animation : true,
	// 动画的步数
	animationSteps : 50,
	// 动画的效果
	animationEasing : "easeOutBounce",	
　　// 是否有从0度到360度的动画
    animateRotate : true,
　　// 是否有从中心到边缘的动画
    animateScale : true,
	// 动画完成后调用
	onAnimationComplete : null
	}
	var baozhangfangshifenbu_ctx = document.getElementById("baozhangfangshifenbu").getContext("2d");
	var baozhangfangshifenbu = new Chart(baozhangfangshifenbu_ctx).Doughnut(baozhangfangshifenbu_data,defaults);
}
//融资期限分布 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
function getRZQXFB(){
	var rongziqixianfenbu_data = [
	{
		value: 30,
		color:"#4FC1E9"
	},
	{
		value : 50,
		color : "#F89135"
	},
	{
		value : 100,
		color : "#F8585B"
	},
	{
		value : 40,
		color : "#FFDC89"
	},
	{
		value : 120,
		color : "#66CC66"
	},
	{
		value : 120,
		color : "#596373"
	}]
	var defaults = {
    // 块和块之间是否有间距
	segmentShowStroke : true,
	// 块和块之间间距的颜色
	segmentStrokeColor : "#fff",
	// 块和块之间间距的宽度
    segmentStrokeWidth : 1,
    // 是否有动画效果	
	animation : true,
	// 动画的步数
	animationSteps : 50,
	// 动画的效果
	animationEasing : "easeOutBounce",	
　　// 是否有从0度到360度的动画
    animateRotate : true,
　　// 是否有从中心到边缘的动画
    animateScale : true,
	// 动画完成后调用
	onAnimationComplete : null
	}
	var rongziqixianfenbu_ctx = document.getElementById("rongziqixianfenbu").getContext("2d");
	var rongziqixianfenbu = new Chart(rongziqixianfenbu_ctx).Doughnut(rongziqixianfenbu_data,defaults);
}
//产品类型分布 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
function getCPLXFB(){
	var chanpinleixingfenbu_data = [
	{
		value: 30,
		color:"#4FC1E9"
	},
	{
		value : 50,
		color : "#F89135"
	},
	{
		value : 100,
		color : "#F8585B"
	},
	{
		value : 40,
		color : "#FFDC89"
	},
	{
		value : 120,
		color : "#66CC66"
	},
	{
		value : 120,
		color : "#596373"
	}]
	var defaults = {
    // 块和块之间是否有间距
	segmentShowStroke : true,
	// 块和块之间间距的颜色
	segmentStrokeColor : "#fff",
	// 块和块之间间距的宽度
    segmentStrokeWidth : 1,
    // 是否有动画效果	
	animation : true,
	// 动画的步数
	animationSteps : 50,
	// 动画的效果
	animationEasing : "easeOutBounce",	
　　// 是否有从0度到360度的动画
    animateRotate : true,
　　// 是否有从中心到边缘的动画
    animateScale : true,
	// 动画完成后调用
	onAnimationComplete : null
	}
	var chanpinleixingfenbu_ctx = document.getElementById("chanpinleixingfenbu").getContext("2d");
	var chanpinleixingfenbu = new Chart(chanpinleixingfenbu_ctx).Doughnut(chanpinleixingfenbu_data,defaults);
}
//融资主体行业分布 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
function getRZZTHYFB(){
	var rongzizhutihangyefenbu_data = [
	{
		value: 30,
		color:"#4FC1E9"
	},
	{
		value : 50,
		color : "#F89135"
	},
	{
		value : 100,
		color : "#F8585B"
	},
	{
		value : 40,
		color : "#FFDC89"
	},
	{
		value : 120,
		color : "#66CC66"
	},
	{
		value : 120,
		color : "#596373"
	}]
	var defaults = {
    // 块和块之间是否有间距
	segmentShowStroke : true,
	// 块和块之间间距的颜色
	segmentStrokeColor : "#fff",
	// 块和块之间间距的宽度
    segmentStrokeWidth : 1,
    // 是否有动画效果	
	animation : true,
	// 动画的步数
	animationSteps : 50,
	// 动画的效果
	animationEasing : "easeOutBounce",	
　　// 是否有从0度到360度的动画
    animateRotate : true,
　　// 是否有从中心到边缘的动画
    animateScale : true,
	// 动画完成后调用
	onAnimationComplete : null
	}
	var rongzizhutihangyefenbu_ctx = document.getElementById("rongzizhutihangyefenbu").getContext("2d");
	var rongzizhutihangyefenbu = new Chart(rongzizhutihangyefenbu_ctx).Doughnut(rongzizhutihangyefenbu_data,defaults);
}
//平台保证金变化 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
function getPTBZJBH(){
	var pingtaibaozhengjinbianhua_data = {
		labels : ["2014-03","2014-04","2014-05","2014-06","2014-07","2014-08","2014-09","2014-10","2014-11","2014-12","2015-01","2015-02","2015-03","2015-04","2015-05","2015-06","2015-07"],
		datasets : [
			{
				fillColor : "rgba(79,193,233,0.5)",//柱状填充颜色
				strokeColor : "rgba(79,193,233,1)",//柱状边框颜色
				pointColor : "rgba(79,193,233,1)",
				pointStrokeColor : "#fff",
				data : [28000,31000000,34000000,48000000,40000000,19000000,56000000,96000000,65000000,27000000,100000000,105000000,139000000,140000000,201000000,140000000,201000000]
			}
		]
	}
	var defaults = {
		// 刻度是否显示标签, 即Y轴上是否显示文字
		scaleShowLabels : true,
		// Y轴上的刻度,即文字
		scaleLabel : "<%=value/10000%>万",
		// 文字大小
		scaleFontSize : 14,
	}
	var pingtaibaozhengjinbianhua_ctx = document.getElementById("pingtaibaozhengjinbianhua").getContext("2d");
	var pingtaibaozhengjinbianhua = new Chart(pingtaibaozhengjinbianhua_ctx).Line(pingtaibaozhengjinbianhua_data,defaults);
}
//投资人年龄/性别分布 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
function getTZRNL_XBFB(){
	var touzirennianling_xingbiefenbu_data = {
		labels : ["0-19","20-29","30-39","40-49","50-59","60+"],
		datasets : [
			{
				fillColor : "rgba(79,193,233,0.5)",//柱状填充颜色
				strokeColor : "rgba(79,193,233,1)",//柱状边框颜色
				pointColor : "rgba(79,193,233,1)",
				pointStrokeColor : "#fff",
				data : [65,59,90,81,56,55]
			},
			{
				fillColor : "rgba(151,187,205,0.5)",
				strokeColor : "rgba(151,187,205,1)",
				pointColor : "rgba(151,187,205,1)",
				pointStrokeColor : "#fff",
				data : [28,48,40,19,96,27,100]
			}
		]
	}
	var touzirennianling_xingbiefenbu_ctx = document.getElementById("touzirennianling_xingbiefenbu").getContext("2d");
	var touzirennianling_xingbiefenbu = new Chart(touzirennianling_xingbiefenbu_ctx).Radar(touzirennianling_xingbiefenbu_data);
}
//投资额渠道分布 - 数据//////////////////////////////////////////////////////////////////////////////////////////////
function getTZEQDFB(){		
	var touziequdaofenbu_data = [
	{
		value: 30,
		color:"#4FC1E9"
	},
	{
		value : 50,
		color : "#F89135"
	},
	{
		value : 60,
		color : "#F8585B"
	}			
	]
	var touziequdaofenbu_ctx = document.getElementById("touziequdaofenbu").getContext("2d");
	var touziequdaofenbu = new Chart(touziequdaofenbu_ctx).Pie(touziequdaofenbu_data);
}

//