package com.attempt.life.service;

import com.attempt.life.po.LoginVo;

public interface UserLoginService {
	
	public boolean UserLogin(LoginVo lg) throws Exception;
	
	public boolean UserRegistered(LoginVo lg) throws Exception;
	public boolean user_update_password(LoginVo lg) throws Exception;
}