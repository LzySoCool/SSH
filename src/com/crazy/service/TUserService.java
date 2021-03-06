package com.crazy.service;

import java.util.List;

import com.crazy.bean.TUser;

public interface TUserService {
	int deleteByPrimaryKey(Integer uid);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKey(TUser record);
    
    List<TUser> queryAll();
    
    int getTotal();
}
