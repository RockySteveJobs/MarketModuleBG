package com.wqz.marketbg.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqz.marketbg.pojo.Carousel;
import com.wqz.marketbg.pojo.Product;
import com.wqz.marketbg.service.ProductService;
import com.wqz.marketbg.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/product")
public class ProductController 
{
	private ProductService iProduct = new ProductServiceImpl();
	
	@RequestMapping(value = "/productGetCarousel" ,method=RequestMethod.GET)
    @ResponseBody
    public List<Carousel> selectCarousel()
    {
        return iProduct.getCarouselList();
    }
	
	@RequestMapping(value = "/productGetSerach" ,method=RequestMethod.GET)
    @ResponseBody
    public List<Product> selectSerach(
    		@RequestParam(required=true)String serach,
    		@RequestParam(required=true)Integer start,
    		@RequestParam(required=true)Integer size)
    {
		return iProduct.getSerach(serach,start,size);
    }
	
	@RequestMapping(value = "/productCreate" ,method=RequestMethod.POST)
    @ResponseBody
    public Integer createProduct(
    		@RequestParam(value="name",required=true)String name,
    		@RequestParam(value="price",required=true)Float price,
    		@RequestParam(value="type",required=true)Integer type,
    		@RequestParam(value="imageaddress",required=true)String imageaddress,
    		@RequestParam(value="introduce",required=true)String introduce)
    {
		return iProduct.insertProduct(new Product(name, price, type, imageaddress, introduce));
    }

	
}
