var CHART_HELPER = function() {
    require.config({
        paths: {
            'echarts': '/vendors/echart',
            'echarts/theme/jmb': '/vendors/echart/themes/jmb',
            'echarts/theme/default': '/vendors/echart/themes/default',
            'echarts/chart/line': '/vendors/echart/charts/line',
            'echarts/chart/pie': '/vendors/echart/charts/pie',
            'echarts/chart/bar': '/vendors/echart/charts/bar',
            'echarts/chart/map': '/vendors/echart/charts/map'
        }
    });
    return {
        drawLineChart: function(el, data, legend, xAxis) {
            var series = [],
                isShowLegend = false;
            if (legend.length > 1) {
                isShowLegend = true;
            }
            for (var i = 0; i < data.length; i++) {
                series.push({
                    name: legend[i],
                    type: 'line',
                    itemStyle: {
                        normal: {
                            areaStyle: {
                                type: 'default'
                            }
                        }
                    },
                    data: data[i]
                });
            }
            var option = {
                tooltip: {
                    trigger: 'axis',
                    formatter: function(params) {
                        return (params[0].value / 10000).toFixed(2) + '万';
                    }
                },
                legend: {
                    show: isShowLegend,
                    data: legend
                },
                calculable: true,
                xAxis: [{
                    type: 'category',
                    boundaryGap: false,
                    data: xAxis
                }],
                yAxis: [{
                    type: 'value',
                    axisLabel: {
                        formatter: function(value) {
                            return (value / 10000) + '万';
                        }
                    }
                }],
                series: series
            };
            require(
                ['echarts', 'echarts/theme/jmb', 'echarts/chart/line'], function(ec, theme) {
                    var chart = ec.init(el, theme);
                    chart.setOption(option);
                });
        },
        drawBarChart: function(el, data, legend, xAxis) {
            var series = [],
                isShowLegend = false;
            if (legend.length > 1) {
                isShowLegend = true;
            }
            for (var i = 0; i < data.length; i++) {
                series.push({
                    name: legend[i],
                    type: 'bar',
                    stack: 'sum',
                    itemStyle: {
                        normal: {
                            barBorderRadius: 0,
                            label: {
                                show: false
                            }
                        }
                    },
                    data: data[i]
                });
            }
            var option = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: { // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                    },
                    formatter: function(params) {
                        var strs = [];
                        if (params[0]) {
                            strs.push(params[0].name + '<br/>' + params[0].seriesName + ' : ' + (params[0].value / 10000).toFixed(2) + '万');
                        }
                        if (params[1]) {
                            strs.push(params[1].seriesName + ' : ' + (params[1].value / 10000).toFixed(2) + '万');
                        }
                        return strs.join('<br>');
                    }
                },
                legend: {
                    show: false,
                    orient: 'horizontal',
                    x: 'center',
                    y: 'top',
                    selectedMode: false,
                    data: legend
                },
                calculable: true,
                xAxis: [{
                    type: 'category',
                    data: xAxis
                }],
                yAxis: [{
                    type: 'value',
                    axisLabel: {
                        formatter: function(value) {
                            return parseFloat(value / 100000000).toFixed(2) + "亿"
                        }
                    }
                }],
                series: series
            };
            require(
                ['echarts', 'echarts/theme/jmb', 'echarts/chart/bar'], function(ec, theme) {
                    var chart = ec.init(el, theme);
                    chart.setOption(option);
                });
        },
        drawPieChart: function(el, data) {
            var dataArray = [],
                other = 0;
            if(data.length > 6){
                for (var i = 0; i < data.length; i++) {
                    if (i < 5) {
                        dataArray.push(data[i]);
                    } else {
                        other += parseFloat(data[i].value);
                        if (i === data.length - 1) {
                            dataArray.push({
                                'name': '其他',
                                'value': other
                            });
                        }
                    }
                }
            }else{
                dataArray = data;
            }
            var legend = [];
            for (var i = 0; i < dataArray.length; i++) {
                legend.push(dataArray[i]);
            }
            var option = {
                tooltip: {
                    trigger: 'item',
                    formatter: "{b} : {d}%"
                },
                legend: {
                    orient: 'vertical',
                    x: 'right',
                    data: legend
                },
                calculable: true,
                series: [{
                    name: '访问来源',
                    type: 'pie',
                    radius: ['60%', '90%'],
                    center: ['40%', '50%'],
                    itemStyle: {
                        normal: {
                            label: {
                                show: false
                            },
                            labelLine: {
                                show: false
                            }
                        },
                        emphasis: {
                            label: {
                                show: false
                            }
                        }
                    },
                    data: dataArray
                }]
            };
            require(
                ['echarts', 'echarts/theme/jmb', 'echarts/chart/pie'], function(ec, theme) {
                    var chart = ec.init(el, theme);
                    chart.setOption(option);
                });
        },
        drawMatrixPieChart: function(el, data1, data2) {
            var legend = [];
            for (var i = 0; i < data2.length; i++) {
                legend.push(data2[i].name);
            }
            var option = {
                tooltip: {
                    trigger: 'item',
                    formatter: "{b} : {d}%"
                },
                legend: {
                    orient: 'vertical',
                    x: 'right',
                    data: legend
                },
                calculable: false,
                series: [{
                    type: 'pie',
                    selectedMode: 'single',
                    radius: [0, '50%'],
                    center: ['40%', '50%'],
                    itemStyle: {
                        normal: {
                            label: {
                                position: 'inner'
                            },
                            labelLine: {
                                show: false
                            }
                        }
                    },
                    data: data1
                }, {
                    type: 'pie',
                    radius: ['60%', '90%'],
                    center: ['40%', '50%'],
                    itemStyle: {
                        normal: {
                            label: {
                                show: false
                            },
                            labelLine: {
                                show: false
                            }
                        },
                        emphasis: {
                            label: {
                                show: false
                            }
                        }
                    },
                    data: data2
                }]
            };
            require(
                ['echarts', 'echarts/theme/jmb', 'echarts/chart/pie'], function(ec, theme) {
                    var chart = ec.init(el, theme);
                    chart.setOption(option);
                });
        },
        drawMapChart: function(el, data, legend, max) {
            var series = [];
            for (var i = 0; i < data.length; i++) {
                series.push({
                    name: legend[i],
                    type: 'map',
                    mapType: 'china',
                    roam: false,
                    itemStyle: {
                        normal: {
                            label: {
                                show: true
                            }
                        },
                        emphasis: {
                            label: {
                                show: true
                            }
                        }
                    },
                    data: data[i]
                });
            }
            var option = {
                tooltip: {
                    trigger: 'item',
                    formatter: function(params) {
                        var value;
                        if (params.value != '-') {
                            value = (params.value / 10000).toFixed(2);
                        } else {
                            value = 0;
                        }
                        return params.name + '<br/>' + value + '万';
                    }
                },
                dataRange: {
                    show: false,
                    min: 0,
                    max: max,
                    x: 'left',
                    y: 'bottom',
                    text: ['高', '低'], // 文本，默认为数值文本
                    calculable: true
                },
                series: series
            };
            require(
                ['echarts', 'echarts/theme/jmb', 'echarts/chart/map'], function(ec, theme) {
                    var chart = ec.init(el, theme);
                    chart.clear()
                    chart.setOption(option);
                });
        },
        drawMatrixMapChart: function(el, data, global, legend, max) {
            var series = [{
                name: '全国',
                type: 'map',
                roam: false,
                hoverable: false,
                mapType: 'china',
                itemStyle: {
                    normal: {
                        borderColor: 'rgba(100,149,237,1)',
                        borderWidth: 0.5,
                        areaStyle: {
                            color: '#1b1b1b'
                        }
                    }
                },
                data: [],
                geoCoord: {
                    '上海': [121.4648,31.2891],
                    '新疆': [87.9236, 43.5883],
                    '甘肃': [103.5901, 36.3043],
                    '北京': [116.4551, 40.2539],
                    '江苏': [118.8062, 31.9208],
                    '广西': [108.479, 23.1152],
                    '江西': [116.0046, 28.6633],
                    '安徽': [117.29, 32.0581],
                    '内蒙古': [111.4124, 40.4901],
                    '黑龙江': [127.9688, 45.368],
                    '天津': [117.4219, 39.4189],
                    '山西': [112.3352, 37.9413],
                    '广东': [113.5107, 23.2196],
                    '四川': [103.9526, 30.7617],
                    '西藏': [91.1865, 30.1465],
                    '云南': [102.9199, 25.4663],
                    '浙江': [119.5313, 29.8773],
                    '湖北': [114.3896, 30.6628],
                    '辽宁': [123.1238, 42.1216],
                    '山东': [117.1582, 36.8701],
                    '海南': [110.3893, 19.8516],
                    '河北': [114.4995, 38.1006],
                    '福建': [119.4543, 25.9222],
                    '青海': [101.4038, 36.8207],
                    '陕西': [109.1162, 34.2004],
                    '贵州': [106.6992, 26.7682],
                    '河南': [113.4668, 34.6234],
                    '重庆': [107.7539, 30.1904],
                    '宁夏': [106.3586, 38.1775],
                    '吉林': [125.8154, 44.2584],
                    '湖南': [113.0823, 28.2568],
                }
            }];

            for (var i = 0; i < data.length; i++) {
                var point = [];
                for(var j=0; j< data[i].length; j++){
                    point.push(data[i][j][1]);
                }
                series.push({
                    name: legend[i],
                    type: 'map',
                    mapType: 'china',
                    data:[],
                    markLine : {
                        smooth:true,
                        effect : {
                            show: true,
                            scaleSize: 1,
                            period: 30,
                            color: '#fff',
                            shadowBlur: 10
                        },
                        itemStyle : {
                            normal: {
                                borderWidth:1,
                                lineStyle: {
                                    type: 'solid',
                                    shadowBlur: 10
                                }
                            }
                        },
                        data : data[i]
                    },
                    markPoint : {
                        symbol:'emptyCircle',
                        symbolSize : function (v){
                            return 10
                        },
                        effect : {
                            show: true,
                            shadowBlur : 0
                        },
                        itemStyle:{
                            normal:{
                                label:{show:false}
                            },
                            emphasis: {
                                label:{position:'top'}
                            }
                        },
                        data : point,

                    }
                });
            }

            var selectedList = {},
                isShow = true;

            for(var k = 0; k< legend.length; k++){
                if(k !== 0){
                    isShow = false;
                }
                selectedList[legend[k]] = isShow;
            }

            var option = {
                backgroundColor: '#1b1b1b',
                tooltip: {
                    trigger: 'item',
                    formatter: function(value){
                        var result = '';
                        if(value[2] != '-'){
                            result = value[1]+ ' ' + (value[3] / 10000).toFixed(2) + "万";
                        }
                        else {
                            result = value[1];
                        }
                        return result;
                    }
                },
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    data: legend,
                    selectedMode: 'single',
                    selected:selectedList,
                    textStyle: {
                        color: '#fff'
                    }
                },
                dataRange: {
                    show: false,
                    min: 0,
                    max: 10000000,
                    calculable: true,
                    textStyle: {
                        color: '#fff'
                    }
                },
                series: series
            };

            require(
                ['echarts', 'echarts/theme/jmb', 'echarts/chart/map'], function(ec, theme) {
                    var chart = ec.init(el, theme);
                    chart.clear()
                    chart.setOption(option);
                });
        }
    };
}();