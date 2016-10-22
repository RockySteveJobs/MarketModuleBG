package com.wqz.marketbg.service.impl;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wqz.marketbg.dao.ProductMapper;
import com.wqz.marketbg.dao.ShoppingCartMapper;
import com.wqz.marketbg.pojo.ShoppingCart;
import com.wqz.marketbg.pojo.ShoppingCartEx;
import com.wqz.marketbg.service.ShoppingCartService;

public class ShoppingCartServiceImpl implements ShoppingCartService
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
    
	public Integer createShoppingCartRecord(ShoppingCart shoppingCart) 
	{
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			ShoppingCartMapper pm = session.getMapper(ShoppingCartMapper.class);
			pm.insertSelective(shoppingCart);
			session.commit();
		}
		finally
		{
			session.close();
		}
		
		return 0;
	}

	public Integer deleteShoppingCartRecord(Integer shoppingCartID) 
	{
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			ShoppingCartMapper pm = session.getMapper(ShoppingCartMapper.class);
			pm.deleteByPrimaryKey(shoppingCartID);
			session.commit();
		}
		finally
		{
			session.close();
		}
		
		return 0;
	}

	public List<ShoppingCartEx> getShoppingCartRecord(Integer userid) 
	{
		List<ShoppingCartEx> scl;
		
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			ProductMapper pm = session.getMapper(ProductMapper.class);
			scl = pm.selectShoppingCart(userid);
		}
		finally
		{
			session.close();
		}
		
		return scl;
	}
	
}
