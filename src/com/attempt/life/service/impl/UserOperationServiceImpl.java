package com.attempt.life.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.attempt.life.mapper.UserMapperCustom;
import com.attempt.life.po.AlldbPageVo;
import com.attempt.life.po.DbDataVo;
import com.attempt.life.po.UserOperationVo;
import com.attempt.life.po.UserhighselectVo;
import com.attempt.life.service.UserOperationService;

public class UserOperationServiceImpl implements UserOperationService{

	
	
	@Autowired
	private UserMapperCustom userMapperCustom;
	//���� love 
	public boolean Userinlove(UserOperationVo us) throws Exception {
		// TODO Auto-generated method stub
	
		userMapperCustom.userinlove(us);
	return true;
	}
	public void Userinhate(UserOperationVo nv) throws Exception {
		// TODO Auto-generated method stub
		userMapperCustom.userinhate(nv);
	}
	
	
	public List<DbDataVo> userselectlove(String username) throws Exception {
		// TODO Auto-generated method stub
	
		return 	userMapperCustom.userselectlove(username);
	}
	public List<DbDataVo> userselecthate(String username) throws Exception {
		// TODO Auto-generated method stub
		return userMapperCustom.userselecthate(username);
	}
	public AlldbPageVo user_select_db(Integer page, String username) throws Exception {
		// TODO Auto-generated method stub
		
		int count =userMapperCustom.user_select_dbcount(username);
		System.out.println("count +++++"+count);
		if (page ==null)
		{
			page = 1 ;
		}
		AlldbPageVo alldbpagevo= new AlldbPageVo(page, 13, count);
		
		System.out.println("pageindexxxxxxx:"+alldbpagevo.getStartIndex());
		System.out.println("totalpage "+ alldbpagevo.getTotalPage());
		 List<DbDataVo> list =  userMapperCustom.user_select_dbstartend(username,alldbpagevo.getStartIndex(),13);//������� pagesize  ǰ����� start index
//		 List<DbDataVo> list =  adminMapperCustom.AdminSelectAllDbDatastartend(31,30);
		 for (int i =0;i <list.size();i++)
		 {
			 list.get(i).setCompanyLogo("//"+ list.get(i).getCompanyLogo());
			 list.get(i).setMaxjianminslary( list.get(i).getMaxsalary()-list.get(i).getMinsalary());
			 
		 }
		 
		 alldbpagevo.setList(list);
		return alldbpagevo;
	}
	//�߼����� �������һ��uv ��ѯ���� 
	
	public AlldbPageVo user_highselect(Integer page, String username, UserhighselectVo uv) throws Exception {
		// TODO Auto-generated method stub
		
		int count =userMapperCustom.user_highselect_dbcount(username,uv);
		System.out.println("count +++++"+count);
		if (page ==null)
		{
			page = 1 ;
		}
		AlldbPageVo alldbpagevo= new AlldbPageVo(page, 13, count);
		
		System.out.println("pageindexxxxxxx:"+alldbpagevo.getStartIndex());
		System.out.println("totalpage "+ alldbpagevo.getTotalPage());
		 List<DbDataVo> list =  userMapperCustom.user_highselect_dbstartend(username,uv,alldbpagevo.getStartIndex(),13);//������� pagesize  ǰ����� start index
//		 List<DbDataVo> list =  adminMapperCustom.AdminSelectAllDbDatastartend(31,30);
		 for (int i =0;i <list.size();i++)
		 {
			
			 list.get(i).setCompanyLogo("//"+ list.get(i).getCompanyLogo());
			 list.get(i).setMaxjianminslary( list.get(i).getMaxsalary()-list.get(i).getMinsalary());
			 
		 }
		 
		 alldbpagevo.setList(list);
		return alldbpagevo;
	}
	
	
}
