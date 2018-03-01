<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航</title>
<head>
<link rel="stylesheet" href="welcome/css/style.css">
<script type="text/javascript" src="welcome/js/jquery.js"></script>
<script type="text/javascript">
	$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
	$(".leftsidebar_box dt img").attr("src","welcome/images/left/select_xl01.png");
	$(function(){
		$(".leftsidebar_box dd").hide();
		$(".leftsidebar_box dt").click(function(){
			$(".leftsidebar_box dt").css({"background-color":"#3992d0"})
			$(this).css({"background-color": "#317eb4"});
			$(this).parent().find('dd').removeClass("menu_chioce");
			$(".leftsidebar_box dt img").attr("src","welcome/images/left/select_xl01.png");
			$(this).parent().find('img').attr("src","welcome/images/left/select_xl.png");
			$(".menu_chioce").slideUp(); 
			$(this).parent().find('dd').slideToggle();
			$(this).parent().find('dd').addClass("menu_chioce");
		});
	})
</script>
</head>

<body id="bg">

<div >

	<div class="leftsidebar_box">
		<div class="line"></div>
		<dl >
		<a target="fname" href="welcome/text.html"><dt >欢迎${loginVo.permission} <br>@${loginVo.username}</dt></a>
		</dl>

		<dl class="custom">			
			<dt onClick="changeImage()">我<img src="welcome/images/left/select_xl01.png"></dt>
			<dd class="first_dd" ><a  target="fname" href="gouser_my">我的信息</a></dd>
			<dd class="first_dd"><a   target="fname" href="Userselectlove">我的收藏</a></dd>
			<dd class="first_dd"><a target="fname" href="Userselecthate">厌恶</a></dd>
			
		</dl>
	
		
	
	
		
	
	
		<dl class="source">
			<dt>查看数据<img src="welcome/images/left/select_xl01.png"></dt>
			
			<dd class="first_dd" ><a  target="fname" href="user_highselect">图形</a></dd>
			<dd class="first_dd"><a  target="fname" href="user_highselectdb">列表</a></dd>
	
		</dl>
		
		<dl class="syetem_management">
			<dt>系统管理<img src="welcome/images/left/select_xl01.png"></dt>
			<dd><a href="userupdatepassword?username=${loginVo.username}" target="fname">修改用户密码</a></dd>
		</dl>
	
	<!-- 	<dl class="statistics">
			<dt>统计分析<img src="welcome/images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="#">客户统计</a></dd>
		</dl> -->
	
	</div>
   
</div>

<div class="fdiv">
 <iframe name="fname" src="welcome/text.html" class="fname"></iframe>
</div>

</body>
</html>
