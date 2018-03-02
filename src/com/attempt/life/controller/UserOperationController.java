package com.attempt.life.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attempt.life.po.AlldbPageVo;
import com.attempt.life.po.MylistVo;
import com.attempt.life.po.UserOperationVo;
import com.attempt.life.po.UserhighselectVo;
import com.attempt.life.service.impl.UserLoginServiceImpl;
import com.attempt.life.service.impl.UserOperationServiceImpl;

@Controller
public class UserOperationController {

	
	@Autowired
	private UserOperationServiceImpl userOperationServiceImpl;
	
	
	@RequestMapping("/Usermy")
	public String Usermy(HttpSession httpSession,Model model)throws Exception{
		//传入用户名 拿到数据
	MylistVo mylistvo=	userOperationServiceImpl.getmy((String)httpSession.getAttribute("username"));
	System.out.println(mylistvo.getHatenum());	
	model .addAttribute("mylist",mylistvo);
		return "user_my";
	}
	
	//喜好 和厌恶的 都不会显示在 全部列表中 
	@RequestMapping("/Userinlove")
	public String Userinlove(String username,String positionid,String page)throws Exception {
		UserOperationVo nv =new UserOperationVo();
		nv.setUsername(username);
		nv.setPositionid(positionid);
			userOperationServiceImpl.Userinlove(nv);
			return "redirect:user_highselectdb?page="+page;
	}
	
	
	@RequestMapping("/Userinhate")
	public String Userinhate( String username,String positionid,String page)throws Exception {
		UserOperationVo nv =new UserOperationVo();
		nv.setUsername(username);
		nv.setPositionid(positionid);
		userOperationServiceImpl.Userinhate(nv);
		
		   return "redirect:user_highselectdb?page="+page;
	}
	@RequestMapping("/Userselectlove")
	public String Userselectlove(Model model,HttpSession httpSession)throws Exception {
		
	String username = (String)httpSession.getAttribute("username");
		model.addAttribute("list", 	userOperationServiceImpl.userselectlove(username));
		   return "user_love";
	}
	@RequestMapping("/Userselecthate")
	public String Userselecthate(Model model,HttpSession httpSession)throws Exception {
		String username = (String)httpSession.getAttribute("username");
		model.addAttribute("list",	userOperationServiceImpl.userselecthate(username));
		
		   return "user_hate";
	}
	
	
	//用户 搜索信息列表！
	@RequestMapping("/user_select_db")
    public String  user_select_db(Model model,Integer page,HttpSession httpSession) throws Exception {
    	//默认 每页13条
		String username = (String)httpSession.getAttribute("username");
    	if (page ==null)
    	{
    		page=1;
    	}
    	AlldbPageVo AlldbPageVo =userOperationServiceImpl.user_select_db(page,username);
    	 model.addAttribute("pagevo", AlldbPageVo);
    	return "user_dblist";
    }
	//列表 高级搜索 
	@RequestMapping("/user_highselectdb")
    public String  user_highselectdb( Model model,HttpServletRequest request,Integer page,HttpSession httpSession) throws Exception {
		int num=1;
		if (page ==null)
    	{
			num = 0;
    		page=1;
    	}
		//判断page 
        //检查是不是有uv 搜索vo    或者 . 第二次搜索
	
		if(httpSession.getAttribute("uv")==null|| num==0) {
		//为空  为新添加uv
			UserhighselectVo uv = new UserhighselectVo();
    	uv .setCity(request.getParameter("city"));
    	uv.setMaxsalary(request.getParameter("maxsalary"));
    	uv.setMinsalary(request.getParameter("minsalary"));
        uv .setPosition(request.getParameter("position"));
        AlldbPageVo alldbPageVo =userOperationServiceImpl.user_highselect(page,(String)httpSession.getAttribute("username"),uv);
             //将uv放到session
        model.addAttribute("pagevo", alldbPageVo);
        httpSession.setAttribute("uv",uv);
		}
		else{
			//   2 . 分页 
			//判断page 
			UserhighselectVo uv =(UserhighselectVo) httpSession.getAttribute("uv");
				//没有page 搜索 
			AlldbPageVo alldbPageVo =userOperationServiceImpl.user_highselect(page,(String)httpSession.getAttribute("username"),uv);
			model.addAttribute("pagevo", alldbPageVo);
		}
		 return "user_dblist_highlist";
    }
	
	
	
	//用户 搜索信息列表！ 图形！
	@RequestMapping("/user_select_db_pi")
    public String  user_select_db_pi(Model model,Integer page,HttpSession httpSession) throws Exception {
    	//默认 每页13条
		String username = (String)httpSession.getAttribute("username");
    	if (page ==null)
    	{
    		page=1;
    	}
    	AlldbPageVo alldbPageVo =userOperationServiceImpl.user_select_db(page,username);
    	 model.addAttribute("pagevo", alldbPageVo);
    	return "user_pilist";
    }
	
	@RequestMapping("/user_highselect")
    public String  user_highselect( Model model,HttpServletRequest request,Integer page,HttpSession httpSession) throws Exception {
		int num=1;
		if (page ==null)
    	{
			num = 0;
    		page=1;
    	}
		//判断page 
        //检查是不是有uv 搜索vo    或者 . 第二次搜索
	
		if(httpSession.getAttribute("uv")==null|| num==0) {
		//为空  为新添加uv
			UserhighselectVo uv = new UserhighselectVo();
    	uv .setCity(request.getParameter("city"));
    	uv.setMaxsalary(request.getParameter("maxsalary"));
    	uv.setMinsalary(request.getParameter("minsalary"));
        uv .setPosition(request.getParameter("position"));
        AlldbPageVo alldbPageVo =userOperationServiceImpl.user_highselect(page,(String)httpSession.getAttribute("username"),uv);
             //将uv放到session
        model.addAttribute("pagevo", alldbPageVo);
        httpSession.setAttribute("uv",uv);
		}
		else{
			//   2 . 分页 
			//判断page 
			UserhighselectVo uv =(UserhighselectVo) httpSession.getAttribute("uv");
				//没有page 搜索 
			AlldbPageVo alldbPageVo =userOperationServiceImpl.user_highselect(page,(String)httpSession.getAttribute("username"),uv);
			model.addAttribute("pagevo", alldbPageVo);
		}
        
      
		 
      
        return "user_pilist_highlist";
    }
	
}
