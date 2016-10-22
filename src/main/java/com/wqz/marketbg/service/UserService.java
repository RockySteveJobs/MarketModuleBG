package com.wqz.marketbg.service;

import com.wqz.marketbg.pojo.User;

public interface UserService 
{
	Integer register(User user);
	
	User login(String account,String password);
	
	Integer update(User user);
	
	Boolean isAccountExist(String testAccount);
}
