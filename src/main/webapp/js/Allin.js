/*整个页面都当做一个实例处理*/
new Vue({
	el: '#app',
	data() {
		return {
			//用 Info 存储当前登录用户的信息
			info:[]
		}	
	},
	mounted() {
		axios
			.get(API.getArrApi())
			.then(response => (this.info = response.data))
			.catch(function(error) { // 请求失败处理
				console.log(error);
			});
	}
});