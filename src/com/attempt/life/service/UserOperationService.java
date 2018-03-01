package com.attempt.life.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.attempt.life.po.AlldbPageVo;
import com.attempt.life.po.DbDataVo;
import com.attempt.life.po.UserOperationVo;
import com.attempt.life.po.UserhighselectVo;

public interface UserOperationService {

	public boolean Userinlove(UserOperationVo us) throws Exception;
	public void Userinhate(UserOperationVo us) throws Exception;
	
	
	public List<DbDataVo> userselectlove(String username) throws Exception;
	public List<DbDataVo> userselecthate(String username) throws Exception;
	public AlldbPageVo user_select_db(Integer page,String username) throws Exception;
	public AlldbPageVo user_highselect(Integer page,String username,UserhighselectVo uv) throws Exception;
	
}
