package com.wqz.marketbg.service;

import java.util.List;

import com.wqz.marketbg.pojo.ShoppingCart;
import com.wqz.marketbg.pojo.ShoppingCartEx;

public interface ShoppingCartService 
{
	Integer createShoppingCartRecord(ShoppingCart shoppingCart);
	
	Integer deleteShoppingCartRecord(Integer shoppingCartID);
	
	List<ShoppingCartEx> getShoppingCartRecord(Integer userid);
}
