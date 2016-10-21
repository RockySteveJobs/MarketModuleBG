package com.wqz.marketbg.dao;

import com.wqz.marketbg.pojo.UserProduct;

public interface UserProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserProduct record);

    int insertSelective(UserProduct record);

    UserProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserProduct record);

    int updateByPrimaryKey(UserProduct record);
}