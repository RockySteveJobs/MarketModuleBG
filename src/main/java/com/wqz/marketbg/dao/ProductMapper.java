package com.wqz.marketbg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wqz.marketbg.pojo.Product;
import com.wqz.marketbg.pojo.ShoppingCartEx;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
    
    List<ShoppingCartEx> selectShoppingCart(
    		@Param(value = "userid")Integer userid);
    
    List<Product> selectSerach(
    		@Param(value = "serach")String serach,
    		@Param(value = "start")Integer start,
    		@Param(value = "size")Integer size);
}