package com.attempt.life.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attempt.life.po.AlldbPageVo;
import com.attempt.life.po.DbDataVo;
import com.attempt.life.po.LoginVo;
import com.attempt.life.po.PageVo;
import com.attempt.life.service.AdaminLoginService;
import com.attempt.life.service.UserLoginService;
import com.attempt.life.service.impl.AdminLoginServiceImpl;
import com.attempt.life.service.impl.UserLoginServiceImpl;





@Controller
public class AdminController {

	@Autowired
	private AdminLoginServiceImpl adminLoginServiceImpl;

	
	    
	    @RequestMapping("/adminlogin")
		public String login( HttpServletRequest request,Model model, LoginVo loginVo )throws Exception {
	   String  username= request.getParameter("username");
		String password=request.getParameter("password");
        LoginVo lg =new LoginVo();
	    lg.setUsername(username);
	    lg.setPassword(password);
		System.out.println(username+"  "+password);
		Boolean result=(Boolean)adminLoginServiceImpl.AdminLogin(lg);
		  System.out.println("result::"+result);
		 if(result==true) {
			 lg.setPermission("admin");
			 System.out.println("管理员登录成功！");
			  model.addAttribute("loginVo", lg);  
			 return "admin_welcome";
		 }
		 else {
			 System.out.println("管理员登录失败！");
			  model.addAttribute("information", "管理员登录失败！");  
			 return "index";
		 }
	    }  
	    @RequestMapping("/admin_select_alluser")
	    public String  SelectAllUser(Model model) throws Exception {
	    List<LoginVo> list= adminLoginServiceImpl.Admin_SelectAllUser();
	    	 model.addAttribute("userlist", list);
	    	return "admin_userlist";
	    }
	    
	    @RequestMapping("/admin_select_alldb")
	    public String  SelectAlldb(Model model,Integer page) throws Exception {
	    	//默认 每页30条
	    	if (page ==null)
	    	{
	    		page=1;
	    	}
	    	AlldbPageVo AlldbPageVo =    adminLoginServiceImpl.Admin_SelectAllDbDatastartend(page);
	    	 model.addAttribute("pagevo", AlldbPageVo);
	    	return "Dball";
	    }
	    
}
