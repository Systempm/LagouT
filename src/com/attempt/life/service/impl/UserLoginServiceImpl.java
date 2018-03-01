package com.attempt.life.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import com.attempt.life.mapper.UserMapperCustom;
import com.attempt.life.po.LoginVo;
import com.attempt.life.service.UserLoginService;


public class UserLoginServiceImpl implements UserLoginService{

	
	@Autowired
	private UserMapperCustom userMapperCustom;
	
	//登录用户 
	public boolean UserLogin(LoginVo lg) throws Exception {
		// TODO Auto-generated method stub
		if(userMapperCustom!=null ) {
	 if (	userMapperCustom.UserLogin(lg)==null || userMapperCustom.UserLogin(lg)==0)
	 { return false;}
	 else return true;
		}
	 
		return false;
	}
//注册用户 
	public boolean UserRegistered(LoginVo lg) throws Exception {
		// TODO Auto-generated method stub
		//先查找一下用户 
		if (userMapperCustom.finduser(lg)==0)
			//查找用户不存在 可以注册 
		{
		int result=userMapperCustom.UserRegistered(lg);
			 if (result==0)
			 { return false;}
			 else return true;
				}
			return false;
		
	}
	public boolean user_update_password(LoginVo lg) throws Exception {
		// TODO Auto-generated method stub
		
		userMapperCustom.UserUpdatepassword(lg);
		
		
		return false;
	}
}
