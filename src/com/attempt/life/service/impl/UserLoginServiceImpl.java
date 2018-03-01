package com.attempt.life.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import com.attempt.life.mapper.UserMapperCustom;
import com.attempt.life.po.LoginVo;
import com.attempt.life.service.UserLoginService;


public class UserLoginServiceImpl implements UserLoginService{

	
	@Autowired
	private UserMapperCustom userMapperCustom;
	
	//��¼�û� 
	public boolean UserLogin(LoginVo lg) throws Exception {
		// TODO Auto-generated method stub
		if(userMapperCustom!=null ) {
	 if (	userMapperCustom.UserLogin(lg)==null || userMapperCustom.UserLogin(lg)==0)
	 { return false;}
	 else return true;
		}
	 
		return false;
	}
//ע���û� 
	public boolean UserRegistered(LoginVo lg) throws Exception {
		// TODO Auto-generated method stub
		//�Ȳ���һ���û� 
		if (userMapperCustom.finduser(lg)==0)
			//�����û������� ����ע�� 
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
