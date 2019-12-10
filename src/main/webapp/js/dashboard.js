$(document).ready(function() {
    drawSummaryChart(source);
    drawPieCharts(source);
    drawPlatformMarginChart(source);
    drawTrasfer(source);
    drawMapChart(source, 'FinancingAmount');
    $("#MapSwitch").find('a').on('click', function() {
        var thisId = $(this).attr('aria-controls');
        if (thisId == 'Transfer') {
            drawTrasfer(source);
        } else {
            drawMapChart(source, thisId);
        }
    })
})

function drawSummaryChart(source) {
    var xAxis = [],
        data = [],
        legend = ['项目直投'],
        monthlyInvestAmountData = [],
        monthlyCreditAssignAmountData = [0, 0, 0, 0, 0, 0],
        monthlyInvestAmount = source.monthlyInvestAmount,
        monthlyCreditAssignAmount = source.monthlyCreditAssignAmount;
    for (var i = 0; i < monthlyInvestAmount.length; i++) {
        xAxis.push(monthlyInvestAmount[i].name);
        monthlyInvestAmountData.push(monthlyInvestAmount[i].value);
    }
    for (var i = 0; i < monthlyCreditAssignAmount.length; i++) {
        monthlyCreditAssignAmountData.push(monthlyCreditAssignAmount[i].value);
    }
    for (var i = 0; i < monthlyInvestAmount.length; i++) {
        data.push(monthlyInvestAmountData[i] + monthlyCreditAssignAmountData[i]);
    }
    CHART_HELPER.drawBarChart($('#project-invest')[0], [monthlyInvestAmountData], legend, xAxis);

    $('.invest-month-report a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        // if ($(e.target).attr('href').indexOf('ProjectInvest') > 0) {
        //     if ($(e.target).attr('data-drawed')) { return; }
        //     $(e.target).attr('data-drawed', true);
        //     CHART_HELPER.drawBarChart($('#project-invest')[0], [monthlyInvestAmountData], legend, xAxis);
        // }

        if ($(e.target).attr('href').indexOf('CreditAssignInvest') > 0) {
            if ($(e.target).attr('data-drawed')) { return; }
            $(e.target).attr('data-drawed', true);
            legend = ['债权转让'],
            CHART_HELPER.drawBarChart($('#creditassign-invest')[0], [monthlyCreditAssignAmountData], legend, xAxis);
        }
    })
};

function drawPieCharts(source) {
    CHART_HELPER.drawPieChart($('#project-guarantee-type')[0], source.projectGuaranteeType);
    CHART_HELPER.drawPieChart($('#project-maturity')[0], source.projectMaturity);
    CHART_HELPER.drawPieChart($('#project-category')[0], source.projectCategory);
    CHART_HELPER.drawPieChart($('#financing-industry')[0], source.financingIndustry);
    CHART_HELPER.drawMatrixPieChart($('#invest-user')[0], source.investUserSex, source.InvestUserAge);
    CHART_HELPER.drawPieChart($('#invest-channel')[0], source.investChannel);
};

function drawPlatformMarginChart(source) {
    var sourceData = source.platformMargin;
    var dataArray = [],
        data = [],
        xAxis = [],
        legend = ['平台保证金'];
    for (var i = 0; i < sourceData.length; i++) {
        data.push(sourceData[i].value);
        xAxis.push(sourceData[i].name);
    }
    dataArray.push(data);
    CHART_HELPER.drawLineChart($('#margins')[0], dataArray, legend, xAxis);
};

function drawTrasfer(source) {
    var data = source.investFlow,
        mapData = [],
        global = [],
        legend = [];
    for (var i = 0; i < data.length; i++) {
        var city = data[i].name,
            items = data[i].items,
            item = [];
        legend.push(city);
        for (var j = 0; j < data[i].items.length; j++) {
            item.push([{
                'name': city
            }, {
                'name': items[j].name,
                'value': items[j].value
            }]);
            var globalItem = [{
                'name': city
            }, {
                'name': items[j].name,
                'value': items[j].value
            }];
            global.push(globalItem);
        }
        mapData.push(item);
    }
    if (!($("#MatrixMap").hasClass('active'))) {
        $("#Map").hide().removeClass('active');
        $('#MatrixMap').show(function() {
            CHART_HELPER.drawMatrixMapChart($('#matrix-map-chart')[0], mapData, global, legend);
        }).addClass('active')
    }
}

function drawMapChart(source, id) {
    var souceKey = '',
        legend = [],
        isAmount = true;
    switch (id) {
        case "FinancingAmount":
            sourceKey = 'projectArea';
            legend = ['融资额'];
            isAmount = true;
            break;
        case "Financy":
            sourceKey = 'financingArea';
            legend = ['融资项目数'];
            isAmount = false;
            break;
        case "InvestAmount":
            sourceKey = 'investAmountArea';
            legend = ['投资额'];
            isAmount = true;
            break;
        // case "Investor":
        //     sourceKey = 'investUserArea';
        //     legend = ['投资人'];
        //     isAmount = false;
        //     break;
        default:
            sourceKey = 'projectArea';
            legend = ['融资额'];
            isAmount = true;
    }
    var data = [];
    data.push(source[sourceKey]);
    var max = data[0][0].value;
    if (!($("#Map").hasClass('active'))) {
        $("#MatrixMap").hide().removeClass('active');
        $('#Map').show(function() {
            CHART_HELPER.drawMapChart($('#map-chart')[0], data, legend, max);
            appendTopTen($("#Map"), data, isAmount);
        }).addClass('active')
    } else {
        CHART_HELPER.drawMapChart($('#map-chart')[0], data, legend, max);
        appendTopTen($("#Map"), data, isAmount);
    }
};

function appendTopTen(el, data, isAmount) {
    var container = el.find(".topTen"),
        template = "<tr><td style='width:20px'>{0}</td><td>{1}</td><td class='text-right num'>{2}</td></tr>";
    container.html('');
    for (var i = 0; i < 10; i++) {
        var row = template
                    .replace("{0}", i + 1)
                    .replace("{1}", data[0][i].name)
                    .replace("{2}", isAmount ? amountFormat(data[0][i].value, 2) : data[0][i].value);
        container.append(row);
    }
}

function amountFormat(s, n) {
    n = n > 0 && n <= 20 ? n : 2;
    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    var l = s.split(".")[0].split("").reverse(),
        r = s.split(".")[1];
    t = "";
    for (i = 0; i < l.length; i++) {
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
    }
    return t.split("").reverse().join("") + "." + r;
};