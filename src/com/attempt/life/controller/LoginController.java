package com.attempt.life.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attempt.life.po.LoginVo;
import com.attempt.life.service.UserLoginService;
import com.attempt.life.service.impl.UserLoginServiceImpl;




//应该叫usercontroller
@Controller
public class LoginController {

	@Autowired
	private UserLoginServiceImpl userLoginServiceImpl;

	    @RequestMapping("/test1")
		public String test1()throws Exception {
		System.out.println("success");
			return "success";
		}
	    
	    @RequestMapping("/login")
		public String login( HttpServletRequest request,Model model, LoginVo loginVo ,HttpSession httpSession)throws Exception {
	   String  username= request.getParameter("username");
		String password=request.getParameter("password");
        LoginVo lg =new LoginVo();
	    lg.setUsername(username);
	    lg.setPassword(password);
		System.out.println(username+"  "+password);
		Boolean result=(Boolean)userLoginServiceImpl.UserLogin(lg);
		  System.out.println("result::"+result);
		 if(result==true) {
			 System.out.println("登录成功！");
			 lg.setPermission("user");
			 httpSession.setAttribute("username", username);
			 model.addAttribute("loginVo", lg); 
			 return "user_welcome";
			 
		 }
		 else {
			 System.out.println("登录失败！");
			 return "err";
		 }
		}
	    
	    @RequestMapping("/registered")
		public String registered( HttpServletRequest request,Model model, LoginVo loginVo)throws Exception {
	   String  username= request.getParameter("username");
		String password=request.getParameter("password");
        LoginVo lg =new LoginVo();
	    lg.setUsername(username);
	    lg.setPassword(password);
		System.out.println(username+"  "+password);
		Boolean result=(Boolean)userLoginServiceImpl.UserRegistered(lg);
		  System.out.println("result::"+result);
		
		 if(result==true) {
			 System.out.println("注册成功");
			String information="注册成功！";
			  model.addAttribute("information", information);  
			 return "login";
			 
		 }
		 else {
			 System.out.println("注册失败,该用户名已经存在");
		String	 information="注册失败,该用户名已经存在";
			  model.addAttribute("information", information);  
			 return "login";
		 }
	
		}
	    
	    @RequestMapping("/user_update_password")
	  		public String user_update_password( HttpServletRequest request,Model model, LoginVo loginVo)throws Exception {
	  	   String  username= request.getParameter("username");
	  		String password=request.getParameter("oldpassword");
	          LoginVo lg =new LoginVo();
	  	    lg.setUsername(username);
	  	    lg.setPassword(password);
	  	    System.out.println(username);
	  	  			if((Boolean)userLoginServiceImpl.UserRegistered(lg)!=null)
			{
				String newpassword=request.getParameter("newpassword");
			      LoginVo newlg =new LoginVo();
			      newlg.setUsername(username);
			      newlg.setPassword(newpassword);
			  	  userLoginServiceImpl.user_update_password(newlg);
			  	  if((Boolean)userLoginServiceImpl.UserRegistered(newlg)!=null) {
			  		model .addAttribute("infor","密码修改成功!");
					return "user_update_password";
			  	  }
			  	  else {
			  		model .addAttribute("infor","密码修改失败 !不知道为什么QAQ！");
					return "user_update_password";
			  	  }
			  	  
			}
			else {
				model .addAttribute("infor","老密码不对  ！请核对后再试OVO!");
				return "user_update_password";
				
			}
			
	    }
	  
}
