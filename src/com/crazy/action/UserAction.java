package com.crazy.action;

import java.util.Date;
import java.util.List;

import com.crazy.bean.TUser;
import com.crazy.service.TUserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private static final long serialVersionUID = -4239529819021954899L;
	
	private TUser user;
	private TUserService userService;
	private List<TUser> list;
	private String mess;
	
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	public void setUserService(TUserService userService) {
		this.userService = userService;
	}
	public List<TUser> getList() {
		return list;
	}
	public void setList(List<TUser> list) {
		this.list = list;
	}
	
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	
	/**
	 * 查询所有用户
	 * @return
	 * @throws Exception
	 */
	public String queryAll()throws Exception{
		list=userService.queryAll();
		int count=userService.getTotal();
		System.out.println("用户个数："+count);
		return SUCCESS;
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	public String addUser(){
		if(user.getUname() == null || "".equals(user.getUname())){
			user.setUname("crazy");
			user.setUpwd("123");
			user.setUmessage("不详");
		}
		user.setUtime(new Date());
		userService.insertSelective(user);
		mess="添加成功";
		return SUCCESS;
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public String delUser(){
		userService.deleteByPrimaryKey(user.getUid());
		mess="删除成功";
		return SUCCESS;
	}
}
