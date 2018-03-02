package com.attempt.life.po;

import java.util.Date;

public class MylistVo {

	

	public String getLoginnum() {
		return loginnum;
	}
	public void setLoginnum(String loginnum) {
		this.loginnum = loginnum;
	}
	public String getLovenum() {
		return lovenum;
	}
	public void setLovenum(String lovenum) {
		this.lovenum = lovenum;
	}
	public String getHatenum() {
		return hatenum;
	}
	public void setHatenum(String hatenum) {
		this.hatenum = hatenum;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	private String username ; 
	private String createtime ; 
	private String loginnum ;
	private String lovenum;
	private String hatenum;
	
	
}
