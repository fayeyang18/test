
var vue=new Vue({
        el: ".left",
        data:{
					//address:[]
					name:"",
					phone:"",
					address:"",
					addrlist:[],
					ind:""
				},
				methods: {
				init:function(){
					var _self=this;

					$.ajax(
					{
						url:'http://localhost:8080/wyyx/defaultaddress',
						dataType:'text',
						type:'get',
						data:{
							utel:utel
						},
						success:function(list){
							var rs = $.parseJSON(list);
							_self.name= rs[0].user_name;
							_self.phone=rs[0].user_tel;
							_self.address=rs[0].user_pro+rs[0].user_city+rs[0].user_area+rs[0].detail_addr;
							_self.addrlist=rs;
						},
						
					});
				},
				changeBgc: function (index) {
					this.ind = index;
					console.log(this.ind)
					
				},
				selectaddr:function()
				{
					var ind = this.ind;
					console.log(this.name);
					this.name=this.addrlist[ind].user_name;
					this.phone=this.addrlist[ind].user_tel;
					this.address=this.addrlist[ind].user_pro+this.addrlist[ind].user_city+this.addrlist[ind].user_area+this.addrlist[ind].detail_addr;
				}
				}
					
    });
    vue.init();

function showpop(){
     var pop1=document.getElementById("tanchuang");
     var pop2=document.getElementById("zhezhao");
     pop1.style.top="20px";
     pop1.style.left="400px";
     pop1.style.visibility = "visible"; 
     pop2.style.visibility = "visible"; 
     
    }
function hidepop(){
var pop1 = document.getElementById("tanchuang");
pop1.style.visibility = "hidden";
var pop2 = document.getElementById("zhezhao");
pop2.style.visibility = "hidden";
} 
