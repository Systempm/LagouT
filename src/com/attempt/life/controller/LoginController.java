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




//Ӧ�ý�usercontroller
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
			 System.out.println("��¼�ɹ���");
			 lg.setPermission("user");
			 httpSession.setAttribute("username", username);
			 model.addAttribute("loginVo", lg); 
			 return "user_welcome";
			 
		 }
		 else {
			 System.out.println("��¼ʧ�ܣ�");
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
			 System.out.println("ע��ɹ�");
			String information="ע��ɹ���";
			  model.addAttribute("information", information);  
			 return "login";
			 
		 }
		 else {
			 System.out.println("ע��ʧ��,���û����Ѿ�����");
		String	 information="ע��ʧ��,���û����Ѿ�����";
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
			  		model .addAttribute("infor","�����޸ĳɹ�!");
					return "user_update_password";
			  	  }
			  	  else {
			  		model .addAttribute("infor","�����޸�ʧ�� !��֪��ΪʲôQAQ��");
					return "user_update_password";
			  	  }
			  	  
			}
			else {
				model .addAttribute("infor","�����벻��  ����˶Ժ�����OVO!");
				return "user_update_password";
				
			}
			
	    }
	  
}
