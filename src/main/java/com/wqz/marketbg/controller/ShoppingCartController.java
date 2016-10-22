package com.wqz.marketbg.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqz.marketbg.pojo.ShoppingCart;
import com.wqz.marketbg.pojo.ShoppingCartEx;
import com.wqz.marketbg.service.ShoppingCartService;
import com.wqz.marketbg.service.impl.ShoppingCartServiceImpl;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController 
{
	ShoppingCartService iShoppingCart = new ShoppingCartServiceImpl();
	
	@RequestMapping(value = "/shoppingCartGet" ,method=RequestMethod.GET)
    @ResponseBody
    public List<ShoppingCartEx> selectShoppingCart(
    		@RequestParam(required=true)Integer userid)
    {
        return iShoppingCart.getShoppingCartRecord(userid);
    }
	
	@RequestMapping(value = "/shoppingCartCreate" ,method=RequestMethod.POST)
    @ResponseBody
    public Integer createShoppingCart(
    		@RequestParam(required=true)Integer userid,
    		@RequestParam(required=true)Integer productid,
    		@RequestParam(required=true)Float price,
    		@RequestParam(required=true)Integer number)
    {
        return iShoppingCart.createShoppingCartRecord(new ShoppingCart(userid, productid, price, number));
    }
	
	@RequestMapping(value = "/shoppingCartDelete" ,method=RequestMethod.POST)
    @ResponseBody
    public Integer updateShoppingCart(@RequestParam(required=true)Integer id)
    {
        return iShoppingCart.deleteShoppingCartRecord(id);
    }
}
