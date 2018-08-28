var vue=new Vue({
el: ".cart-box-body",
data:{
	boxs:[],
	all:"",
	goods_list:[]
},
methods: {
init:function(){
	var _self=this;

	$.ajax(
	{
		url:'json/pro.json',
		dataType:'text',
		type:'get',
		success:function(result){
			var rs = $.parseJSON(result);
			_self.goods_list = rs;
		}
	});
},
changeNumber: function (goods, event) {
	var obj = $(event.target);
	goods.num = parseInt(obj.val());
},
add: function (goods) {
	goods.num = parseInt(goods.num+1);
},
sub: function (goods) {
	goods.num = parseInt(goods.num-1);
},
remove: function (goods) {
	for(var i=0;i<this.goods_list.length;i++)
	{
		if(this.goods_list[i]==goods){
			this.goods_list.splice(i,1);
		}
	}
},
removesome: function () {
	for(var i=0;i<this.boxs.length;i++)
	{
		for(var j=0;j<this.goods_list.length;j++)
		{
			if(this.boxs[i]==this.goods_list[j].id)
			{
				this.goods_list.splice(j,1);
				break;
			}
		}
	}
},
select:function(){
	if(this.all){
		this.boxs=[];
		for(var i=0;i<this.goods_list.length;i++)
		{
			this.boxs.push(this.goods_list[i].id);
		}
	}else{
		this.boxs=[];
		}
	},
change:function(){
	if(boxs.length!=0)
	{
		this.staus="已选";
	}
	else{
		this.staus="全选"
	}
}},
computed:{
	count : function(){
		var num = 0;
		for(var i in this.goods_list){
			for(var j in this.boxs)
			{
				if(this.goods_list[i].id==this.boxs[j])
				{
					num += parseInt(this.goods_list[i].num);
				}
			}
		}
		return num;
	},
	total : function(){
		var total = 0;
		for(var i in this.goods_list){
			for(var j in this.boxs)
			{
				if(this.goods_list[i].id==this.boxs[j])
				{
					total += this.goods_list[i].price * this.goods_list[i].num;
				}
			}
		}
		return total;
	},
}
});
vue.init();