<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.attempt.life.po.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
admin _user list
<% List<LoginVo> list =(List<LoginVo>) request.getAttribute("userlist"); %>
<table border="1">
  <tr>
    <th>username</th>
    <th>password</th>
  </tr>
  <%for (int i  = 0 ;i <list .size();i++) {%>
  <tr>
    <td><%=list.get(i).getUsername()  %></td>
    <td><%=list.get(i).getPassword()  %></td>
  </tr>
  <% }%>
</table>
</body>
</html>