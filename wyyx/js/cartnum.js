var vss=new Vue({
el: ".search",
data:{
	num:"0",
	utel:utel
},
methods: {
init:function(){
	var _self=this;

	$.ajax(
	{
		url:'http://localhost:8080/wangyi//Servlet/getcartnum',
		dataType:'text',
		type:'get',
		data:{
			utel:utel
		},
		success:function(result){
			var rs = $.parseJSON(result);
			_self.num = rs;
			console.log(rs)
		}
	});
	
}
}
});
vss.init();