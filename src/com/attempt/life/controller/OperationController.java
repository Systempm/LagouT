package com.attempt.life.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attempt.life.po.LoginVo;

@Controller
public class OperationController {

	@RequestMapping("/gowelcome")
	public String gowelcome()throws Exception {
		   return "welcome";
	}
	
	@RequestMapping("/in")
	public String in()throws Exception {
		   return "login";
	}
	
	@RequestMapping("/userupdatepassword")
	public String userupdatepassword(HttpServletRequest request,Model model ,String username)throws Exception {
		  System.out.println(username+"!!!!!!!!!!!");
		  model.addAttribute("username",username);
		   return "user_update_password";
	}
	@RequestMapping("/goerr")
	public String goerr()throws Exception {
		   return "err";
	}
	@RequestMapping("/gouser_my")
	public String gouser_my()throws Exception {
		   return "user_my";
	}
	
}
