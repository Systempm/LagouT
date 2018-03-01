<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.attempt.life.po.DbDataVo , com.attempt.life.po.AlldbPageVo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
show_user_db_list
<% AlldbPageVo alldbPageVo =(AlldbPageVo) request.getAttribute("pagevo");
List<DbDataVo> list =alldbPageVo.getList(); %>

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
	<script type="text/javascript">
	function topdisplay(){
	  var topwidth = document.body.clientWidth +"px"
		if ( document.getElementById("topinside").style.display=="inline")
			{
	  document.getElementById("topsearch").style.width="50px";
	  document.getElementById("topsearch").style.background="none";
	  document.getElementById("topinside").style.display="none";
	  document.getElementById("yincangsrc").style.display="inline";
	  document.getElementById("yincangsrc").style.transform="rotate(0deg)";
	  document.getElementById("topsearch").style.left="15px";
	  document.getElementById("topsearch").style.top="15px";

			}
		else if  ( document.getElementById("topinside").style.display=="none")
		{
			 document.getElementById("topsearch").style.background="rgba(255,255,255,0.6)";
  document.getElementById("topsearch").style.width=topwidth;
  document.getElementById("topinside").style.display="inline";
  document.getElementById("yincangsrc").style.transform="rotate(180deg)";
  document.getElementById("topsearch").style.left="0px";
  document.getElementById("topsearch").style.top="0px";
		}
		
  }
	</script>
<table border="1">
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
  <%for (int i  = 0 ;i <list .size();i++) {%>
  <tr>
  <td><img alt="" src="//<%=list.get(i).getCompanyLogo() %>" style="width: 50px"height="50px"> </td>
   <td> <a href="https://www.lagou.com/jobs/<%=list.get(i).getPositionId() %>.html" target= _blank><%=list.get(i).getCompanyFullName()  %></a></td>
    <td><%=list.get(i).getPositionName()  %></td>
         <td><%=list.get(i).getPositionAdvantage()  %></td>
             <td><%=list.get(i).getSalary()  %></td>
                   <td><%=list.get(i).getWorkYear()  %></td>
                     <td><%=list.get(i).getEducation()  %></td>
                       <td><%=list.get(i).getCity()  %></td>
                         <td><%=list.get(i).getDistrict()  %></td>
                           <td><%=list.get(i).getCompanySize()  %></td>
                                 <td><%=list.get(i).getCreateTime()  %></td>
              <td><a href="Userinlove?username=<%=session.getAttribute("username") %>&positionid=<%=list.get(i).getPositionId() %>"> 收藏 </a> || <a href="Userinhate?username=<%=session.getAttribute("username") %>&positionid=<%=list.get(i).getPositionId() %>">厌恶</a> </td>   
  </tr>
  <% }%>
</table>

<div id="topsearch" style="display:inline; position: fixed;width: 1000px;height: 100px;left:0px; top:0px;background:rgba(255,255,255,0.6) "  >

        <div id="topinside" style="display:inline ;height: 100% ;float:left" z-index =110  ">
        <form action="user_highselectdb" >
<input type="radio" name="city" value="北京"  /> 北京
<input type="radio" name="city" value="上海"  /> 上海
<input type="radio" name="city" value="深圳"  /> 深圳
<input type="radio" name="city" value="杭州"  /> 杭州
<input type="radio" name="city" value="大连"  /> 大连
<input type="radio" name="city" value="沈阳"  /> 沈阳

<br>
        职位-： <input type="text" name="position" > <br>
      
        工资-：        <select name="minsalary"> <option value="">不限制</option>   
        <%for (int ii=1;ii <20;ii++){ %> <option value="<%=ii %>"><%=ii %>K</option> <%} %></select> 
        to 
        <select name="maxsalary">  <option value="">不限制</option> 
        <%for (int jj=1;jj <20;jj++){ %> <option value="<%=jj %>"><%=jj %>K</option> <%} %>
      <option value="100">20K+</option> 
      </select>
        <input type="submit" value="搜索">
        
      </form>
         </div>
    <a onclick="topdisplay()"  >  <img src="pi/you.png" style="display: inline; width: 30px ;height:  60px ;transform:rotate(180deg) ;float: left" id="yincangsrc"  ></a>

</div>
<div >
<p style="float: left">
<%=alldbPageVo.getPageNum() %>页/<%=alldbPageVo.getTotalPage() %>页
<%for(int j = alldbPageVo.getStart() ; j <alldbPageVo.getEnd()+1;j++){ %> 
 <a href="user_select_db?page=<%=j %>"target="fname"><%=j %></a>
<%} %>
 <select  name="totalpage" onchange="window.location=this.value;"  >
<%for (int a = 1 ; a <alldbPageVo.getTotalPage();a++){ 
	if (a==alldbPageVo.getPageNum()){

	%><option value="user_select_db?page=<%=a %>" selected><%=a %>页</option>   
<%}else{%>

   <option value="user_select_db?page=<%=a %>"><%=a %>页</option>   
<%}} %>
</select>
</p>
<p style="float: right"><%=alldbPageVo.getTotalRecord() %> 条数据</p>
</div>
</body>
</html>