package com.attempt.life.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.attempt.life.mapper.AdminMapperCustom;
import com.attempt.life.mapper.UserMapperCustom;
import com.attempt.life.po.AlldbPageVo;
import com.attempt.life.po.DbDataVo;
import com.attempt.life.po.LoginVo;
import com.attempt.life.service.AdaminLoginService;
import com.attempt.life.service.UserLoginService;


public class AdminLoginServiceImpl implements AdaminLoginService{

	
	@Autowired
	private AdminMapperCustom adminMapperCustom;
	
	//��¼�û� 
	public boolean AdminLogin(LoginVo lg) throws Exception {
		// TODO Auto-generated method stub
		if(adminMapperCustom!=null ) {
	 if (	adminMapperCustom.AdminLogin(lg)==null || adminMapperCustom.AdminLogin(lg)==0)
	 { return false;}
	 else return true;
		}
	 
		return false;
	}

	public List<LoginVo> Admin_SelectAllUser() throws Exception {
		// TODO Auto-generated method stub
		return adminMapperCustom.AdminSelectAllUser();
	}



	public Integer Admin_SelectcountAllDbData() throws Exception {
		// TODO Auto-generated method stub
		return adminMapperCustom.AdminSelectcountAllDbData();
	}
	 //д�� �̶�ÿҳ��ʮ��  ��һ��ҳ���Ĳ���
	//����һ�� pagevo ����   ������һ�� list<dbdata vo>
	public AlldbPageVo Admin_SelectAllDbDatastartend(Integer page) throws Exception {
		// TODO Auto-generated method stub
		int count =adminMapperCustom.AdminSelectcountAllDbData();
		System.out.println("count +++++"+count);
		if (page ==null)
		{
			page = 1 ;
		}
		AlldbPageVo alldbpagevo= new AlldbPageVo(page, 13, count);
		
		System.out.println("pageindexxxxxxx:"+alldbpagevo.getStartIndex());
		System.out.println("totalpage "+ alldbpagevo.getTotalPage());
		 List<DbDataVo> list =  adminMapperCustom.AdminSelectAllDbDatastartend(alldbpagevo.getStartIndex(),13);//������� pagesize  ǰ����� start index
//		 List<DbDataVo> list =  adminMapperCustom.AdminSelectAllDbDatastartend(31,30);
		 alldbpagevo.setList(list);
		
		return alldbpagevo;
	}

		
	
}
