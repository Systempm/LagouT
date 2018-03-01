package com.attempt.life.service;

import java.util.List;

import com.attempt.life.po.AlldbPageVo;
import com.attempt.life.po.DbDataVo;
import com.attempt.life.po.LoginVo;

public interface AdaminLoginService {
	
	public boolean AdminLogin(LoginVo lg) throws Exception;
	
	//admin �鿴�����û�
	public List<LoginVo> Admin_SelectAllUser() throws Exception;

	//�鿴count ���� 
	public Integer Admin_SelectcountAllDbData() throws Exception;
	//��start��end��
	public AlldbPageVo Admin_SelectAllDbDatastartend(Integer Page) throws Exception;
}