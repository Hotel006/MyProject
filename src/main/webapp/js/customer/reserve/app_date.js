(function($) {
	$.fn.extend({
		app_date: function(opt) {
			console.log(opt)
			var $this = $(this),
				default_opt = {
					min_date: new Date(),
					max_date: new Date((new Date()) * 1 + 15552000000),
					onSelect: null,
					title: '',
					id: 'date_' + (new Date() * 1) + Math.random()
				},
				opt = $.default_opt(opt, default_opt);
			var start_date = $.get_date_obj(opt.min_date),
				end_date = $.get_date_obj(opt.max_date)
				//console.log(opt)
			function create_table(y, m) {
				var table = '',
					this_m = $.get_date_obj(new Date(y, m - 1, 1)),
					first_day_week = (new Date(y, m - 1, 1)).getDay(),
					last_day = $.get_date_obj(new Date(y, m, 0));
				table = '<table class="app_date" width="100%"><thead><tr><th colspan="7">' + this_m.y + '年' + this_m.m + '月' + '</th></tr></thead>';
				table += '<tbody><tr class="week_few"><td>日</td><td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td></tr>';
				table += '<tr>';
				for (var i = 0; i < first_day_week; i++) {
					table += '<td class="close"></td>';
				};
				for (var i = 1; i <= last_day.d; i++) {
					var aday = $.get_date_obj(new Date(y, m - 1, i));
					if (aday.week == 0) {
						table += '<tr>';
					}
					table += '<td data-y="' + aday.y + '" data-m="' + aday.m + '" data-d="' + aday.d + '" class="' + (aday.str < opt.min_date * 1 ? 'date_before' : (aday.str > opt.max_date * 1 ? 'date_after' : 'date_allow')) + '"><span>' + i + '</span></td>';
					if (aday.week == 6) {
						table += '</tr>'
					}
				}
				for (var i = 0; i < (6 - last_day.week); i++) {
					table += '<td class="close"></td>'
				}
				if (last_day.week < 6) {
					table += '</tr>'
				}
				table += '</tbody></table>';
				return table;
			}
			var dom = '<div id="' + opt.id + '" style="z-index:10000;" class="modal"><header class="bar bar-nav"><a class="icon icon-close pull-right" onclick="$(\'#' + opt.id + '\').removeClass(\'active\')"></a>';
			dom += '<h1 class="title">' + opt.title + '</h1></header><div class="content">';

			for (i = 0; i < Math.ceil((opt.max_date - opt.min_date) / 2592000000); i++) {
				dom += create_table(start_date.y, start_date.m + i)
			}
			dom += '</div></div>'
			$('body').append(dom);
			$('#' + opt.id).find('td.date_allow').click(function(event) {
				$('#' + opt.id).find('td.date_allow').removeClass('active');
				$(this).addClass('active');
				$this.text($(this).data('y') + '-' + $(this).data('m') + '-' + $(this).data('d'));
				$this.val($(this).data('y') + '-' + $(this).data('m') + '-' + $(this).data('d'));
				$this.data('obj', $.get_date_obj(new Date($(this).data('y'), $(this).data('m') - 1, $(this).data('d'))))
				if (opt.onSelect) {
					opt.onSelect($this.data('obj'));
				}
				$('#' + opt.id).removeClass('active')

			});
			$this.click(function() {
				$('#' + opt.id).addClass('active');
			});
			return $this;
		}
	});


	$.extend({
		default_opt: function(opt, default_opt) {
			if (!opt) opt = {};
			for (x in default_opt) {
				opt[x] = (opt[x] !== 0 && opt[x] !== false && opt[x]) ? opt[x] : default_opt[x];
			}
			return opt;
		},
		get_date_obj: function(day) {
			return {
				y: day.getFullYear(),
				m: day.getMonth() + 1,
				d: day.getDate(),
				week: day.getDay(),
				str: day * 1
			}
		},
		get_week_day: function(num) {
			return ['日', '一', '二', '三', '四', '五', '六'][num]
		}
	});
})(jQuery);