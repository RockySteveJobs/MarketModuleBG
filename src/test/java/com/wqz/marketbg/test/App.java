package com.wqz.marketbg.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wqz.marketbg.dao.ProductMapper;
import com.wqz.marketbg.pojo.Product;

public class App 
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

	public static void main( String[] args )
    {
		Product p;
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			ProductMapper pm = session.getMapper(ProductMapper.class);
			p = pm.selectByPrimaryKey(1);
		}
		finally
		{
			session.close();
		}
		
		System.out.println(
				p.getId() + "\n" + 
				p.getPrice() + "\n" + 
				p.getType() + "\n" + 
				p.getName() + "\n");
    }
}
