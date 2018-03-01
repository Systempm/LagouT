<%@page import="java.util.List, com.attempt.life.po.DbDataVo , com.attempt.life.po.AlldbPageVo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <script type="text/javascript">
  function init(){
	  //向右移动的div
 var clientWidth= document.body.clientWidth - 40 +"px"
 var topwidth = document.body.clientWidth +"px"
 console.log("width ",clientWidth)
//上面的div
	 document.getElementById("nextdivv").style.left=clientWidth;
 document.getElementById("topsearch").style.width=topwidth;
 }
  function goright(){
	  if (typeof window.pageYOffset != 'undefined') {
          t = window.pageYOffset;
          l=window.pageXOffset;
          window.scrollTo(l+120,t);
                    }
	  else  if (document.documentElement && document.documentElement.scrollTop) {
	        t = document.documentElement.scrollTop;
	        l = document.documentElement.scrollLeft;
	        window.scrollTo(l+120,t);
	    } else if (document.body) {
	    	 t = document.body.scrollTop;
	   	  l = document.body.scrollLeft;
	   	
	   	  window.scrollTo(l+120,t);
	    }
	  
	  console.log(l)
	  	  console.log(t)
	  
	  //左右移动
  }
  function goleft(){
	  if (typeof window.pageYOffset != 'undefined') {
          t = window.pageYOffset;
          l=window.pageXOffset;
          window.scrollTo(l-120,t);
                    }
	  else	  if (document.documentElement && document.documentElement.scrollTop) {
	        t = document.documentElement.scrollTop;
	        l = document.documentElement.scrollLeft;
	        window.scrollTo(l-120,t);
	    } else if (document.body) {
	    	 t = document.body.scrollTop;
	   	  l = document.body.scrollLeft;
	   	
	   	 window.scrollTo(l-120,t);
	    }
	  
	  
	  
  }
   
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
  function serch(){
	  
	 var sreach=  document.getElementById("sreach").value;
	  console .log  (sreach);
	  if (sreach != null )
{
		  var  hrefd = " windows.location.href= \"selectcity?position="+sreach +"\"" ;
		  console .log  (hrefd);
		  even(hrefd)
		  }
	  else {
		  
		  windows.location.href="selectcity"
	  }
		
  }
  
 </script>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>


<body onload="init()" style=" overFlow-x:hidden;overFlow-y:scroll;height: 837px  ">

<div id="body1" style="height:867px;width:1200px;background: black ;padding-left:50px "   >

<% List<com.attempt.life.po.DbDataVo> ll=null;
int size=0;
AlldbPageVo pb=null;
if (request.getAttribute("pagevo")!=null){

	pb = (AlldbPageVo)request.getAttribute("pagevo");
	System.out.println("pb now page:"+pb.getPageNum());
	ll=pb.getList();
	if (ll.size()>=30){
		 size = 30;
	}
	else {
		size=ll.size();
	}

}


%>



<%for (int  i  = 0;i <size;i ++){ %>


<%if(i%14==0){%>

	<div style="background: green;height: 837px;width: 80px ;float: left; margin-right:1px; position:relative" id = "divwidth" >
	<div align="center" style="background: white;height: 61px;width: 100% ; margin-bottom:1px"></div>
	<% for (int j = 0 ;j<25;j++){%>
	<div align="center" style="background: white;height: 30px;width: 100% ; margin-bottom:1px">
	  <%=j*1%>K -<%=(j+1)*1%>K 
	</div> 
   
<%}%>
 <div align="center" style="background: white;height: 30px;width: 100% ; margin-bottom:1px">
	   +++
	</div> 
	</div>
		
<% } %>




                                                           <!--宽度 调高度 -->
<div id="<%=i %>" style="background: white;height: 837px;width: 80px ; float:left; margin-right:1px;position:relative">
                                                   <!-- logo调高度 -->
<div id ="logo<%= i%>" style="width: 100%; height: 61px " >
<img src="<%=ll.get(i).getCompanyLogo() %>"  width="100%" height="100%">
</div>
    <p style="Writing-mode:tb-rl">    <%=ll.get(i).getPositionName() %>  <br> <%=ll.get(i).getCompanshortname() %></p>            
    
                      
                                                                                        
                                          <% int top = ll.get(i).getMinsalary()*31+62;
                                         int  height=ll.get(i).getMaxjianminslary()*31;
                                          if(top + height>837)
                                        	  {
                                        	  if (top >=837)
                                        	  { top = 837;height=50;  }
                                        	  else{
                                        		  height=837-top+30;
                                        	  }
                                        	  }%>                                 <!-- 调高度 -->                                                                              <!-- 调高度 -->
<div id="div1-b" style="color: yellow; position:absolute;top:<%=top%>px;background: green ;width: 100% ;height: <%=height%>px">

<%=ll.get(i).getSalary() %><br><%=ll.get(i).getWorkYear()%><br><%=ll.get(i).getEducation()%>   </div> 
</div>
<%} %>
<!--  跳转 a href 分页 -->
      <div id="nextpage" style="background: white;height: 837px;width:60px ; float:right; margin-right:1px">    
        <p style="float: left">
        <br><br>
        <br>
<%=pb.getPageNum() %>页
<br>/
<br>
<%=pb.getTotalPage() %>页
<br>
<%for(int j = pb.getStart() ; j <pb.getEnd()+1;j++){ %> 
 <a href="user_highselect?page=<%=j %>"target="fname"><%=j %></a><br>
<%} %>

 <select  name="totalpage" onchange="window.location=this.value;"  >
<%for (int a = 1 ; a <pb.getTotalPage();a++){ 
	if (a==pb.getPageNum()){

	%><option value="user_highselect?page=<%=a %>" selected><%=a %>页</option>   
<%}else{%>

   <option value="user_highselect?page=<%=a %>"><%=a %>页</option>   
<%}} %>
</select>
<br><br><br><br><br><br>
</p>共<br>
<%=pb.getTotalRecord() %> <br>条
<br>数据
     </div>



</div>

<div id="nextdivv" style="position: fixed;width: 35px;height: 70px;left:0px; top:300px " z-index =100 onclick="goright()"><img src="pi/you.png"style="width: 100%;height: 100%  "  ></div>
<div id="nextdivv" style="position: fixed;width: 35px;height: 70px;left:10px; top:300px" z-index =100 onclick="goleft()"><img src="pi/you.png"style="width: 100%;height: 100% ;transform:rotate(180deg)"></div>

<div id="topsearch" style="display:inline; position: fixed;width: 1000px;height: 100px;left:0px; top:0px;background:rgba(255,255,255,0.6) "  >

        <div id="topinside" style="display:inline ;height: 100% ;float:left" z-index =110  ">
        <form action="user_highselect" >
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

</body>
</html>