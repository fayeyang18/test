var v=new Vue({
el: "#main-nav",
data:{
	firstnav:[],
	boxs:[],
	utelephone:utel
},
methods: {
init:function(){
	var _self=this;

	$.ajax(
	{
		url:'json/nav.json',
		dataType:'text',
		type:'get',
		success:function(result){
			var rs = $.parseJSON(result);
			_self.firstnav = rs;
		}
	});
	
},
},
mounted:  function () {
            var  lis  = document.getElementsByClassName("nav-item");
            console.log(lis.length);
        }
});
v.init();