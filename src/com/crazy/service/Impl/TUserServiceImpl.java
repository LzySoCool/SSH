package com.crazy.service.Impl;

import java.util.List;

import com.crazy.bean.TUser;
import com.crazy.dao.TUserDao;
import com.crazy.service.TUserService;

public class TUserServiceImpl implements TUserService{
	private TUserDao userDao;
	
	public void setUserDao(TUserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public int deleteByPrimaryKey(Integer uid) {
		return userDao.deleteByPrimaryKey(uid);
	}

	@Override
	public int insertSelective(TUser record) {
		return userDao.insertSelective(record);
	}

	@Override
	public TUser selectByPrimaryKey(Integer uid) {
		return userDao.selectByPrimaryKey(uid);
	}

	@Override
	public int updateByPrimaryKey(TUser record) {
		return userDao.updateByPrimaryKey(record);
	}

	@Override
	public List<TUser> queryAll() {
		return userDao.queryAll();
	}

	@Override
	public int getTotal() {
		return userDao.getTotal();
	}

}
