package com.attempt.life.service;

import java.util.List;

import com.attempt.life.po.AlldbPageVo;
import com.attempt.life.po.DbDataVo;
import com.attempt.life.po.LoginVo;

public interface AdaminLoginService {
	
	public boolean AdminLogin(LoginVo lg) throws Exception;
	
	//admin 查看所有用户
	public List<LoginVo> Admin_SelectAllUser() throws Exception;

	//查看count 数据 
	public Integer Admin_SelectcountAllDbData() throws Exception;
	//有start和end的
	public AlldbPageVo Admin_SelectAllDbDatastartend(Integer Page) throws Exception;
}