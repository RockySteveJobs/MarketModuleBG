package com.wqz.marketbg.service;

import java.util.List;

import com.wqz.marketbg.pojo.Carousel;
import com.wqz.marketbg.pojo.Product;

public interface ProductService 
{
	List<Carousel> getCarouselList();
	
	List<Product> getSerach(String serach,Integer start,Integer size);
	
	Integer insertProduct(Product product);
}
