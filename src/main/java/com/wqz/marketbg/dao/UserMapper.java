package com.wqz.marketbg.dao;

import org.apache.ibatis.annotations.Param;

import com.wqz.marketbg.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User login(@Param(value = "account")String account,
    		   @Param(value = "password")String password);
    
    Integer getAccountCount(@Param(value = "account")String account);
}