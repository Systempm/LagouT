package com.attempt.life.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.attempt.life.po.DbDataVo;
import com.attempt.life.po.LoginVo;
import com.attempt.life.po.UserOperationVo;

public interface AdminMapperCustom {
	
	
	public Integer AdminLogin(@Param("loginVo")LoginVo loginVo) throws Exception;
	//admin 查看所有用户 
	public List<LoginVo> AdminSelectAllUser() throws Exception;
	public Integer AdminSelectcountAllDbData() throws Exception;
	public List<DbDataVo> AdminSelectAllDbDatastartend(	@Param("pageindex")Integer pageindex,@Param("pagesize")Integer pagesize) throws Exception;
	

}