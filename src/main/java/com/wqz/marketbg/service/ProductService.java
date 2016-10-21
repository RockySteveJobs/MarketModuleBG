package com.wqz.marketbg.service;

import java.util.List;

import com.wqz.marketbg.pojo.Carousel;
import com.wqz.marketbg.pojo.Product;
import com.wqz.marketbg.pojo.ShoppingCartEx;

public interface ProductService 
{
	List<Carousel> getCarouselList();
	
	List<ShoppingCartEx> getShoppingCart(Integer userid);
	
	List<Product> getSerach(String serach,Integer start,Integer size);
	
}
