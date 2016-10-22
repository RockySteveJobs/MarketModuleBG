package com.wqz.marketbg.service.impl;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wqz.marketbg.dao.UserMapper;
import com.wqz.marketbg.pojo.User;
import com.wqz.marketbg.service.UserService;

public class UserServiceImpl implements UserService
{
	private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader; 

    static
    {
        try
        {
            reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession()
    {
        return sqlSessionFactory;
    }
    
	public Integer register(User user) 
	{
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			UserMapper um = session.getMapper(UserMapper.class);
			um.insertSelective(user);
			session.commit();
		}
		finally
		{
			session.close();
		}
		return 0;
	}

	public User login(String account, String password) 
	{
		User user;
		
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			UserMapper um = session.getMapper(UserMapper.class);
			user = um.login(account, password);
		}
		finally
		{
			session.close();
		}
		return user;
	}

	public Integer update(User user) 
	{
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			UserMapper um = session.getMapper(UserMapper.class);
			um.updateByPrimaryKeySelective(user);
			session.commit();
		}
		finally
		{
			session.close();
		}
		return 0;
	}

	public Boolean isAccountExist(String testAccount) 
	{
		Integer count;
		
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			UserMapper um = session.getMapper(UserMapper.class);
			count = um.getAccountCount(testAccount);
		}
		finally
		{
			session.close();
		}
		
		if(count == 0)
			return false;
		else
			return true;
	}
	
}
