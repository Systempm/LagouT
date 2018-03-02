package com.attempt.life.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.attempt.life.po.DbDataVo;
import com.attempt.life.po.LoginVo;
import com.attempt.life.po.MylistVo;
import com.attempt.life.po.UserOperationVo;
import com.attempt.life.po.UserhighselectVo;

public interface UserMapperCustom {
	
	
	public Integer UserLogin(@Param("loginVo")LoginVo loginVo) throws Exception;
	public Integer UserRegistered(@Param("loginVo")LoginVo loginVo) throws Exception;
	public Integer finduser(@Param("loginVo")LoginVo loginVo) throws Exception;
	public Integer UserUpdatepassword(@Param("loginVo")LoginVo loginVo) throws Exception;
	public Integer userinlove(@Param("userOperationVo")UserOperationVo userOperationVo) throws Exception;
	public Integer userinhate(@Param("userOperationVo")UserOperationVo userOperationVo) throws Exception;
	public List<DbDataVo> userselectlove(@Param("username")String username) throws Exception;
	public List<DbDataVo> userselecthate(@Param("username")String username) throws Exception;
	public Integer user_select_dbcount(@Param("username")String username)throws Exception;
	public List<DbDataVo> user_select_dbstartend(@Param("username")String username,@Param("pageindex")Integer startIndex,@Param("pagesize") Integer i)throws Exception;
	public Integer user_highselect_dbcount(@Param("username")String username,@Param("uv")UserhighselectVo uv)throws Exception;
	public List<DbDataVo> user_highselect_dbstartend(@Param("username")String username,@Param("uv")UserhighselectVo uv,@Param("pageindex")Integer startIndex,@Param("pagesize") Integer i)throws Exception;
	public MylistVo selectmy(@Param("username")String username)throws Exception;
	public void loginone(@Param("lg")LoginVo lg)throws Exception;
}
