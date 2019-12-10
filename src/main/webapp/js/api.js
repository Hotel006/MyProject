/*api.js 定义接口的路由与测试路由*/
/*将来可以通过更换model 来变更接口的模式  test会用test模式 prod是正式接口*/
let model = "test";

let API = {
	/*获取当前登录用户的api*/
	getArrApi:function (){
		let api = {
			test:"data/data1.json",//这个是定义了测试的api地址，你用的其实是个json
			prod:""//这个定义的是一个真实的api地址，我还没做好，做好了 就是文档里面的那个地址
		}
		
		return api[model];
	},
}

