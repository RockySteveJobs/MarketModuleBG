package com.wqz.marketbg.service.impl;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wqz.marketbg.dao.CarouselMapper;
import com.wqz.marketbg.dao.ProductMapper;
import com.wqz.marketbg.pojo.Carousel;
import com.wqz.marketbg.pojo.Product;
import com.wqz.marketbg.service.ProductService;

public class ProductServiceImpl implements ProductService
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

    
	public List<Carousel> getCarouselList() 
	{
		List<Carousel> cl;
		
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			CarouselMapper cm = session.getMapper(CarouselMapper.class);
			cl = cm.selectCarousel();
		}
		finally
		{
			session.close();
		}
		
		return cl;
	}

	
	public List<Product> getSerach(String serach,Integer start,Integer size) 
	{
		List<Product> pl;
		
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			ProductMapper pm = session.getMapper(ProductMapper.class);
			pl = pm.selectSerach(serach,start,size);
		}
		finally
		{
			session.close();
		}
		
		return pl;
	}
	
	public Integer insertProduct(Product product) 
	{
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			ProductMapper pm = session.getMapper(ProductMapper.class);
			pm.insertSelective(product);
			session.commit();
		}
		finally
		{
			session.close();
		}
		
		return 0;
	}
}
