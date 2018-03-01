<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.attempt.life.po.DbDataVo , com.attempt.life.po.AlldbPageVo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
user_love_list
<% 
List<DbDataVo> list =(List<DbDataVo>) request.getAttribute("list"); %>

<!--companshortname;
	private String companyFullName;
	private String positionName;
	private String positionId;
	private String positionAdvantage;
	private String salary;
	private int minsalary;
	private int maxsalary;
	private String workYear;
	private String education;
	private String city;
	private String district;
	private String companySize;
	private String companyLogo;
	private String companyLabelList;
	private int Maxjianminslary;  -->
<table border="1">
  <% if (list.size()!=0){%>
  <tr>
   <th>Logo</th>
    <th>公司</th>
    <th>职位</th>

    <th>职位介绍</th>
    <th>工资</th>
    <th>工作年限</th>
    <th>教育</th>
    <th>城市</th>
    <th>区</th>
    <th>公司规模</th>
    <th>发布时间</th>
       <th>操作</th>
  </tr>
  <%} %>
  <%for (int i  = 0 ;i <list .size();i++) {%>
  <tr>
  <td><img alt="" src="//<%=list.get(i).getCompanyLogo() %>" style="width: 50px"height="50px"> </td>
    <td><%=list.get(i).getCompanyFullName()  %></td>
    <td><%=list.get(i).getPositionName()  %></td>
         <td><%=list.get(i).getPositionAdvantage()  %></td>
             <td><%=list.get(i).getSalary()  %></td>
                   <td><%=list.get(i).getWorkYear()  %></td>
                     <td><%=list.get(i).getEducation()  %></td>
                       <td><%=list.get(i).getCity()  %></td>
                         <td><%=list.get(i).getDistrict()  %></td>
                           <td><%=list.get(i).getCompanySize()  %></td>
                                 <td><%=list.get(i).getCreateTime()  %></td>
                                 <td >0.0.0 删除？</td>
  </tr>
  <% }%>
</table>


</body>
</html>