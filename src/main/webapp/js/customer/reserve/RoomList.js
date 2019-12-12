var RoomChannel = function($, rc){
	//统计总入住天数
	var getTotalDays = function(date1, date2) {
		var dateTime1 = Date.parse(date1),
			dateTime2 = Date.parse(date2);
	
		if(isNaN(dateTime1) || isNaN(dateTime2)) {
			var date1Arr = date1.split('-'),
				date2Arr = date2.split('-');
	
			dateTime1 = new Date(date1Arr[0], parseInt(date1Arr[1]) - 1, date1Arr[2]).getTime();
			dateTime2 = new Date(date2Arr[0], parseInt(date2Arr[1]) - 1, date2Arr[2]).getTime();
		}
	
		var totalDays = (dateTime2 - dateTime1) / (24 * 60 * 60 * 1000);
	
		return totalDays;
	};
	
	//字符串转为日期
	var stringToGetTime = function(d){
		var dt = Date.parse(d);
		if(isNaN(dt)){
			var dArr = d.split('-');
			
			dt = new Date(dArr[0], parseInt(dArr[1]) - 1, dArr[2]).getTime();
		}
		return dt;
	}
	
	//获取早餐名称
	var getBreakfastName = function(isInclude, amount, flag){
		var bfName = '';
		if(isInclude){
			switch(amount){
				case 0: bfName = '无早'; break;
				case 1: bfName = '单早'; break;
				case 2: bfName = '双早'; break;
				default: bfName = '--'; break;
			}	
		} else {
			bfName = '无早';
		}
		
		if(flag){
			bfName = '部分' + bfName;
		}
		
		return bfName;
	}
	
	//获取渠道列表
	var getChannelList = function() {
		$.ajax({
			type: 'post',
			url: '/ajax.aspx?at=getChannels',
			async: true,
//			data: {
//				HotelIds: HotelIds
//			},
			dataType: 'json',
			success: function(resp, status) {
				if(status == 'success') {
					//$('.index_sc').hide();
					if(resp.msgInfo.ctripHotelID){
						$('#channelBooking').show();
						$('#channelBooking').find('#ctripChannel').attr('href', 'http://www.jiudianzaixian.cn/go.aspx?ctripHotelID=' + resp.msgInfo.ctripHotelID);	
					}
				}
			}
		});
	};
	
	var getValueAddsBreakfast = function(ValueAdds, ArrivalDate, DepartureDate){
		var oBreakfast = {};
		var totalDays = getTotalDays(ArrivalDate, DepartureDate);
		$.each(ValueAdds, function(i, item) {
			if(item.TypeCode == '99') {
				console.log(item.ValueAddId + ',' + item.Description);
				var startDate = item.StartDate.substring(0, item.StartDate.indexOf('T'));
				var endDate = item.EndDate.substring(0, item.EndDate.indexOf('T'));
				
				var startDateTime = stringToGetTime(startDate),
					endDateTime = stringToGetTime(endDate),
					checkInDateTime = stringToGetTime(ArrivalDate),
					checkOutDateTime = stringToGetTime(DepartureDate);
		
				var accordDate = 0;
				for(var i = 0; i < totalDays; i++) {
					var tmpDate = checkInDateTime + (i * 24 * 60 * 60 * 1000);
					var tmpDay = new Date(tmpDate).getDay() + 1;
					if(tmpDate >= startDateTime && tmpDate <= endDateTime && item.WeekSet.indexOf(tmpDay + ',') >= 0) {
						accordDate++;
					}
				}
		
				var breakfastName = '';
				if(accordDate == totalDays) {
					//所有日期都符合
					breakfastName = getBreakfastName(item.IsInclude, item.Amount, false);
				} else if(accordDate == 0) {
					//所有日期都不符合
					breakfastName = '';
				} else if(accordDate < totalDays) {
					//部分日期符合
					breakfastName = getBreakfastName(item.IsInclude, item.Amount, true);
				}
				oBreakfast['n' + item.ValueAddId] = {
					typeCode: item.TypeCode,
					breakfast: breakfastName
				};
		
			} else if(item.TypeCode == '01') {
				//console.log(item.TypeCode, item.Description, getBreakfastName(item.IsInclude, item.Amount));
				oBreakfast['n' + item.ValueAddId] = {
					typeCode: item.TypeCode,
					breakfast: getBreakfastName(item.IsInclude, item.Amount, false)
				};
			}
		});
		
		return oBreakfast;
	}
	rc.getValueAddsBreakfast = getValueAddsBreakfast;
	
	var getRatePlanBreakfast = function(ValueAddIds, oBreakfast){
		var breakfastName = '';
		var breakfastValueAddIdsArr = ValueAddIds.split(',');
		if(breakfastValueAddIdsArr == 0) {
			breakfastName = '无早';
		} else {
			var breakfastName99 = '';
			$.each(breakfastValueAddIdsArr, function(i, itemValueId) {
				if(oBreakfast['n' + itemValueId]) {
					if(oBreakfast['n' + itemValueId].typeCode == '99') {
						breakfastName99 = oBreakfast['n' + itemValueId].breakfast;
					} else {
						breakfastName = oBreakfast['n' + itemValueId].breakfast;
					}
				}
			});
			breakfastName = (breakfastName99 != '' ? breakfastName99 : breakfastName);
		}
		
		return breakfastName;
	}
	rc.getRatePlanBreakfast = getRatePlanBreakfast;
	
	rc.getLocalRoomList = function(ArrivalDate, DepartureDate, LocalHotelId){
		if(!LocalHotelId){
			getChannelList();
			return false;
		}
		var today = ['周日', '周一', '周二', '周三', '周四', '周五', '周六'];
		var totalDays = getTotalDays(ArrivalDate, DepartureDate); //总天数
		var nowDay = new Date(Date.parse(ArrivalDate));
		if(isNaN(nowDay)) {
			var dateArr = ArrivalDate.split('-');
			nowDay = new Date(dateArr[0], parseInt(dateArr[1]) - 1, dateArr[2]);
		}
		var getDay = nowDay.getDay();
		var week = "";
		var weeks = "";
		if(totalDays > 0) {
			for(var i = 0; i < totalDays; i++) {
				var j = getDay + i;
				week = today[(j % 7)];
				weeks += week + "|";
				if(i == 6) break;
			}
		} else {
			alert("入住日期和离店日期不能是同一天");
			return false;
		}
		
		$('#roomList').show();
		$('#channelBooking').show();
		
		$.ajax({
			type:'get',
			//url:'/template/p1/js/localPrice.json',
			url:'localRooms.aspx?at=getLocalAllRooms&hotelID=' + LocalHotelId + '&ArrivalDate=' + ArrivalDate + '&DepartureDate=' + DepartureDate + '&d=' + new Date().getTime(),
			async:true,
			dataType:'json',
			data:{},
			success: function(resp, status){
				if(status == 'success'){
					var outHtml = '';
					var Rooms = resp.Rooms;
					if(Rooms.length == 0){
						getChannelList();
						return false;
					}
					if(resp.Rooms.length > 0){
						var roomListHtml = $.map(resp.Rooms, function(item) {
							var RatePlans = item.RatePlans;
							var tmpHtml = '    <div class="oneroom">' +
					                    '      <div class="roominfo">' +
					                    '      	<p>' + item.Name + '</p>' +
					                    '      	<p class="des">' + item.Description + '</p>' +
					                    '      </div>' +
					                    '      <div class="rateplanlist">' +
					                    '      	<ul>';
					        $.each(RatePlans, function(i, rpItem) {
								var isMf = false;
								$.each(rpItem.NightlyRates, function(i, nrItem) {
									if(!nrItem.Status || nrItem.Member == -1) {
										isMf = true;
										//break;
									}
								});
								
								tmpHtml += '        	<li>' +
				                        '            	<a href="/localOrder' + rpItem.RoomTypeId + '_' + rpItem.RatePlanId + '.html?checkIn=' + ArrivalDate + '&checkOut=' + DepartureDate + '">' +
				                        '            		<span class="rpname">' + rpItem.RatePlanName + '</span>' +
				                        '                	<span class="price">￥' + rpItem.AverageRate + '</span>' +
				                        '                	<span class="book">' + (isMf ? '<button class="btn" disabled>订完</button>' : '<button class="btn btn-negative">预订</button>') + '</span>' +
				                        '                </a>' +
				                        '            </li>';
							});
							
							tmpHtml += '        </ul>' +
				                    '      </div>' +
				                    '    </div>';
					        
							return tmpHtml;
						}).join('');
						
						outHtml += roomListHtml;
					}
					
					$('#roomList').html(outHtml);
				}
			},
			error: function(xhr){
				getChannelList();
			}
		});
	};
	
	rc.getRoomList = function(ArrivalDate, DepartureDate, HotelIds, LocalHotelId) {
		var _self = this;
		if(HotelIds == ''){
			_self.getLocalRoomList(ArrivalDate, DepartureDate, LocalHotelId);
			//getChannelList();
			return false;
		}
		var today = ['周日', '周一', '周二', '周三', '周四', '周五', '周六'];
		var totalDays = getTotalDays(ArrivalDate, DepartureDate); //总天数
		var nowDay = new Date(Date.parse(ArrivalDate));
		if(isNaN(nowDay)) {
			var dateArr = ArrivalDate.split('-');
			nowDay = new Date(dateArr[0], parseInt(dateArr[1]) - 1, dateArr[2]);
		}
		var getDay = nowDay.getDay();
		var week = "";
		var weeks = "";
		if(totalDays > 0) {
			for(var i = 0; i < totalDays; i++) {
				var j = getDay + i;
				week = today[(j % 7)];
				weeks += week + "|";
				if(i == 6) break;
			}
		} else {
			alert("入住日期和离店日期不能是同一天");
			return false;
		}
	
		var getElongPrice = $.ajax({
			type: 'get',
			url: 'http://price.leyohotel.com/hotelData.aspx?at=hotel.detail&ArrivalDate=' + ArrivalDate + '&DepartureDate=' + DepartureDate + '&HotelIds=' + HotelIds + '&callback=?',
			async: true,
			dataType: 'json'
		}).then(function(data) {
			if(data.Code != '0') {
				//getChannelList();
				_self.getLocalRoomList(ArrivalDate, DepartureDate, LocalHotelId);
	
				return false;
			}
			var hotels = data.Result.Hotels;
			if(hotels.length == 0) {
				//getChannelList();
				_self.getLocalRoomList(ArrivalDate, DepartureDate, LocalHotelId);
	
				return false;
			}
			var oneHotel = hotels[0];
			var HotelId = oneHotel.HotelId;
			var LowRate = oneHotel.LowRate;
			var CurrencyCode = oneHotel.CurrencyCode;
			var Rooms = oneHotel.Rooms;
			if(!Rooms || Rooms.length == 0) {
				_self.getLocalRoomList(ArrivalDate, DepartureDate, LocalHotelId);
				//getChannelList();
	
				return false;
			}
			
			$('#roomList').show();
			$('#channelBooking').show();
	
			//增值服务
			var oBreakfast = getValueAddsBreakfast(oneHotel.ValueAdds, ArrivalDate, DepartureDate);
			console.log(oBreakfast);
			
			var outHtml = '';
			for(var i = 0; i < Rooms.length; i++) {
				var oneRoom = Rooms[i];
				var RatePlans = Rooms[i].RatePlans;
				
				outHtml += '    <div class="oneroom">' +
                    '      <div class="roominfo">' +
                    '      	<p>' + oneRoom.Name + '</p>' +
                    '      	<p class="des">' + oneRoom.Description + '</p>' +
                    '      </div>' +
                    '      <div class="rateplanlist">' +
                    '      	<ul>';
				for(var j = 0; j < RatePlans.length; j++) {
					var isMf = false;
					for(var k = 0; k < RatePlans[j].NightlyRates.length; k++) {
						if(RatePlans[j].NightlyRates[k].Status == false || RatePlans[j].NightlyRates[k].Member == "-1") {
							isMf = true;
							break;
						}
					}
						
					outHtml += '        	<li>' +
                        '            	<a href="/order' + RatePlans[j].RoomTypeId + '_' + RatePlans[j].RatePlanId + '.html?checkIn=' + ArrivalDate + '&checkOut=' + DepartureDate + '">' +
                        '            		<span class="rpname">' + RatePlans[j].RatePlanName + '</span>' +
                        '                	<span class="price">￥' + RatePlans[j].AverageRate + '</span>' +
                        '                	<span class="book">' + (isMf ? '<button class="btn" disabled>订完</button>' : '<button class="btn btn-negative">预订</button>') + '</span>' +
                        '                </a>' +
                        '            </li>';
				}
				
				outHtml += '        </ul>' +
                    '      </div>' +
                    '    </div>';
			}
			
			$("#roomList").html(outHtml);
		});
	};
	
	return rc;
}(jQuery, RoomChannel || {});
			

function GetRoomList(ArrivalDate, DepartureDate, HotelIds) {
    var totalDays = GetTotalDay(ArrivalDate, DepartureDate); //总天数
    var day = new Date(Date.parse(ArrivalDate));
    var getDay = day.getDay();
    if (totalDays <= 0) {
        alert("入住日期和离店日期不能是同一天");
        return false;
    }

    $.getJSON("http://price.leyohotel.com/hotelData.aspx?at=hotel.detail&ArrivalDate=" + ArrivalDate + "&DepartureDate=" + DepartureDate + "&HotelIds=" + HotelIds + "&callback=?", function (data) {
        var hotels = data.Result.Hotels;
        if (hotels.length == 0) {
            alert("房型查询失败,请刷新重试！");
            return false;
        }
        var oneHotel = hotels[0];
        var HotelId = oneHotel.HotelId;
        var LowRate = oneHotel.LowRate;
        var CurrencyCode = oneHotel.CurrencyCode;
        var outHtml = '';
        var Rooms = oneHotel.Rooms;
        for (var i = 0; i < Rooms.length; i++) {
            var oneRoom = Rooms[i];
            var RatePlans = Rooms[i].RatePlans;
            outHtml += '    <div class="oneroom">' +
                    '      <div class="roominfo">' +
                    '      	<p>' + oneRoom.Name + '</p>' +
                    '      	<p class="des">' + oneRoom.Description + '</p>' +
                    '      </div>' +
                    '      <div class="rateplanlist">' +
                    '      	<ul>';
            for (var j = 0; j < RatePlans.length; j++) {
                var isMf = false;
                for (var k = 0; k < RatePlans[j].NightlyRates.length; k++) {
                    if (RatePlans[j].NightlyRates[k].Status == false || RatePlans[j].NightlyRates[k].Member == "-1") {
                        isMf = true;
                        break;
                    }
                }

                outHtml += '        	<li>' +
                        '            	<a href="/order' + RatePlans[j].RoomTypeId + '_' + RatePlans[j].RatePlanId + '.html?checkIn=' + ArrivalDate + '&checkOut=' + DepartureDate + '">' +
                        '            		<span class="rpname">' + RatePlans[j].RatePlanName + '</span>' +
                        '                	<span class="price">￥' + RatePlans[j].AverageRate + '</span>' +
                        '                	<span class="book">' + (isMf ? '<button class="btn" disabled>订完</button>' : '<button class="btn btn-negative">预订</button>') + '</span>' +
                        '                </a>' +
                        '            </li>';
            }
            outHtml += '        </ul>' +
                    '      </div>' +
                    '    </div>';
        }
        $("#roomList").html(outHtml);
    });
}