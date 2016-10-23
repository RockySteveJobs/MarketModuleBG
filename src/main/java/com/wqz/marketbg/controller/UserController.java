package com.wqz.marketbg.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqz.marketbg.pojo.User;
import com.wqz.marketbg.service.UserService;
import com.wqz.marketbg.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController 
{
	UserService iUser = new UserServiceImpl();
	
	@RequestMapping(value = "/register" ,method=RequestMethod.POST)
    @ResponseBody
    public Integer register(@RequestParam(required=true)String account,
    		@RequestParam(required=true)String password)
    {
		if(checkAccount(account))
			return 1;
		
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setRegistertime(new Date());
		user.setType(0);
		
        return iUser.register(user);
    }
	
	@RequestMapping(value = "/login" ,method=RequestMethod.GET)
    @ResponseBody
    public User login(@RequestParam(required=true)String account,
    		@RequestParam(required=true)String password)
    {
        return iUser.login(account, password);
    }
	
	@RequestMapping(value = "/update" ,method=RequestMethod.POST)
    @ResponseBody
    public Integer update(@RequestParam(required=true)Integer id,
    		String nickname,String phone,String password,
    		Integer type,String icon,Integer score)
    {
		User user = new User();
		user.setId(id);
		if(nickname != null)
			user.setNickname(nickname);
		if(phone != null)
			user.setPhone(phone);
		if(password != null)
			user.setPassword(password);
		if(type != null)
			user.setType(type);
		if(icon != null)
			user.setIcon(icon);
		if(score != null)
			user.setScore(score);
		
        return iUser.update(user);
    }
	
	@RequestMapping(value = "/checkAccount" ,method=RequestMethod.GET)
    @ResponseBody
    public Boolean checkAccount(@RequestParam(required=true)String testAccount)
    {
        return iUser.isAccountExist(testAccount);
    }
}
