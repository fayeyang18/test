$(function(){
		    //定义i变量为动态控制图片轮播做准备，i的值与每张图片进行一一的对应
		    var i=0;
		    //时间变量，为自动轮播以及对光标的影响做出相应的反应
		    var timer=null;
		    //根据图片的张数动态添加圆点个数
		    for (var j = 0; j < $('.img1>div').length; j++) {
		        $('.num1').append('<li></li>');
		    }
		    //默认情况下的第一个圆点进行背景设计
		    $('.num1 li').first().addClass('active');
		    //根据光标的影响控制按钮的显示和隐藏
		    $('.banner1').hover(function(){
		        $('.btn').show();
		    },function(){
		        $('.btn').hide();
		    });
		     var firstimg=$('.img1>div').first().clone(); //复制第一张图片
	    	$('.img1').append(firstimg).width($('.img1>div').length*($('.img1 img').width()));
		    //定时器自动轮播
			console.log($('.img1>div').length)
		    timer=setInterval(function(){
		        i++;
		        if (i==$('.img1>div').length-3) {
		            i=0;
		            $('.img1').css({left:0});//保证无缝轮播，设置left值
		        }
		        //进行下一张图片
		        $('.img1').stop().animate({left:-i*365},500);
		        //圆点跟着变化
		        if (i==$('.img1>div').length-1) {
		            $('.num1 li').eq(0).addClass('active').siblings().removeClass('active');
		        }else{
		            $('.num1 li').eq(i).addClass('active').siblings().removeClass('active');
		        }
		    },1000);
		    //鼠标移入，暂停自动播放，移出，开始自动播放
		    $('.banner1').hover(function(){
		        clearInterval(timer);
		    },function(){
		        timer=setInterval(function(){
		            i++;
		            if (i==($('.img1>div').length-3)) {
		                i=0;
		                $('.img1').css({left:0});
		            };
		            //进行下一张图片
		            $('.img1').stop().animate({left:-i*365},500);
		            //圆点跟着变化
		            if (i==$('.img1>div').length-1) {
		                $('.num1 li').eq(0).addClass('active').siblings().removeClass('active');
		            }else{
		                $('.num1 li').eq(i).addClass('active').siblings().removeClass('active');
		            }
		        },1000)
		    });
		    //上一个按钮
		    $('.prev1').click(function(){
		        i--;
		        if (i==-1) {
		            i=$('.img1>div').length-4;
		            $('.img1').css({left:-($('.img1>div').length-1)*365});
		        }
		        $('.img1').stop().animate({left:-i*365},500);
		        $('.num1 li').eq(i).addClass('active').siblings().removeClass('active');
		    });
		    // 下一个按钮
		    $('.next1').click(function(){
		        i++;
		        if (i==$('.img1>div').length-3) {
		            i=1; //这里不是i=0
		            $('.img1').css({left:0});
		        };
		        $('.img1').stop().animate({left:-i*365},500);
		        if (i==$('.img1>div').length-1) { //设置小圆点指示
		            $('.num1 li').eq(0).addClass('active').siblings().removeClass('active');
		        }else{
		            $('.num1 li').eq(i).addClass('active').siblings().removeClass('active');
		        };
		 
		    });
		    //鼠标划入圆点
		    $('.num1 li').mouseover(function(){
		        var _index=$(this).index();
		        //维持i变量控制的对应关系不变
		        i = _index;                 
		        $('.img1').stop().animate({left:-_index*365},300);
		        $('.num li').eq(_index).addClass('active').siblings().removeClass('active');
		    });
		 
		})