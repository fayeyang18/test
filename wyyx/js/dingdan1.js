var app = new Vue({
			el: '.addr',
			data: {
				message: 'Hello Vue!',
				list: [],
				pro: '北京',
				city: '北京',
				cityArr: [],
				dis: '东城区',
				disArr: [],
				username:"",
				telephone:"",
				detail_addr:""
				
			},

			methods: {
				updateCity: function() {
					for(var i in this.list) {
						if(this.pro === this.list[i].name) {
							this.cityArr = this.list[i].child
							break
						}
					}
					this.city = this.cityArr[0].name;
					this.disArr = this.cityArr[0].child;
					this.dis = this.disArr[0].value;
				},

				updateDir: function() {
					for(var i in this.cityArr) {
						if(this.city === this.cityArr[i].name) {
							this.disArr = this.cityArr[i].child
							break
						}
					}
					this.dis = this.disArr[0].value;
				},
				init: function() {

					var _self = this;

					$.ajax({
						type: "get",
						url: "json/all_addr.json",
						dataType: "text",
						success: function(result) {
							var rs = $.parseJSON(result)
							_self.list = rs
							_self.cityArr = _self.list[0].child;
							_self.disArr = _self.list[0].child[0].child;
						}

					})

				},
				submitaddr: function(){
					_self=this;
				$.ajax({
					type:"post",
					url:"http://localhost:8080/wyyx/address",
					data:{
						province:_self.pro,
						citys:_self.city,
						area:_self.dis,
						uname:_self.username,
						utel:_self.telephone,
						udetail:_self.detail_addr,
						utelphone:utel
					},
					success:function(result){
						if(result.status=="success"){
							var url = "dingdan2.html?utel="+utel;
							window.location.href=url;
						}
						else{
							alert(result.message);
						}
					}
				})
				}
				
			}

		})
		app.init();	