package com.wqz.marketbg.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqz.marketbg.pojo.Carousel;
import com.wqz.marketbg.pojo.Product;
import com.wqz.marketbg.pojo.ShoppingCartEx;
import com.wqz.marketbg.service.ProductService;
import com.wqz.marketbg.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/market")
public class MarketModuleController 
{
	private ProductService iProduct = new ProductServiceImpl();
	
	@RequestMapping(value = "/productGetCarousel")
    @ResponseBody
    public List<Carousel> selectCarousel()
    {
        return iProduct.getCarouselList();
    }
	
	@RequestMapping(value = "/productGetShoppingCart")
    @ResponseBody
    public List<ShoppingCartEx> selectShoppingCart(
    		@RequestParam(required=true)Integer userid)
    {
        return iProduct.getShoppingCart(userid);
    }
	
	@RequestMapping(value = "/productGetSerach")
    @ResponseBody
    public List<Product> getSerach(
    		@RequestParam(required=true)String serach,
    		@RequestParam(required=true)Integer start,
    		@RequestParam(required=true)Integer size)
    {
		return iProduct.getSerach(serach,start,size);
    }
}
