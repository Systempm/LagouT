<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
user_update_password<br>

<form action="user_update_password">
 用户名：<input type="text" name="username" class="username"  value="${username}" readonly="readonly"><br>
           旧密码   : <input type="password" name="oldpassword" class="password" placeholder="旧密码 "  >
<br>         <新密码>  :     <input type="password" name="newpassword" class="password" placeholder="新密码"  >
<br> <button type="submit" class="submit_button">提交修改</button>

${infor}
</form>
</body>
</html>