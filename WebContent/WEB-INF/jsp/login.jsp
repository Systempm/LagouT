<html>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html lang="en" class="no-js" >

    <head>

        <meta charset="utf-8">
        <title>登录/注册(Login/register)</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">
		<script src="assets/js/jquery-1.8.2.min.js" ></script>
        <script src="assets/js/supersized.3.2.7.min.js" ></script>
        <script src="assets/js/supersized-init.js" ></script>
        <script src="assets/js/scripts.js" ></script>
<script type="text/javascript">
function registeredsubmit(){
	//提交form
	document.userform.action="registered";
	document.userform.submit();
}


function adminlogin(){
	//提交form
	document.userform.action="adminlogin";
	document.userform.submit();
}
</script>
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="assets/js/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>登录/注册</h1>
            <form  name="userform" action="login" method="post" >
                <input type="text" name="username" class="username" placeholder="请输入您的用户名！" value="${loginVo.username}">
                <input type="password" name="password" class="password" placeholder="请输入您的用户密码！ "  value="${loginVo.password}">
                <input type="Captcha" class="Captcha" name="Captcha" placeholder="请输入验证码！"><br> 抱歉暂时没有验证码!<br>
             ${information} 
                <button type="submit" class="submit_button">登录</button>
                  <button type="button" class="submit_button" onclick="registeredsubmit()">注册</button>
                   <button type="button" class="">游客入口</button>
                            <button type="button" class="" onclick="adminlogin()">管理入口</button>
                <div class="error"><span>+</span></div>
            </form>          
        </div>	
    </body>

</html>

