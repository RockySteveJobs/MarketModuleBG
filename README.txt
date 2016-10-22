首先谢谢你用我的软件啦。这是我写的第一个开源，多有不足，请多指教。

PowerBy：WangCheese

-----------------------------------------------------------------------
接口说明：

默认根地址:
	http://localhost:8080/marketbg

User模块：/user

	1.注册 /register POST
		参数：
			必选：
			String account
			String password

		返回值：0 (注册成功)

	2.登录 /login GET
		参数：
			必选：
			String account
			String password

		返回值：User信息 (登录成功)
				null (登录失败)

	3.更新信息 /update POST
		参数：
			必选：
			Integer id

			可选：
			String nickname
			String phone
			String password
    		Integer type
    		String icon
    		Integer score

		返回值：User信息 (登录成功)
				null (登录失败)

	4.检测账号是否重复 /checkAccount GET
		参数：
			必选：
			String testAccount

		返回值：Boolean

Product模块：/product

	1.得到轮播图片 /productGetCarousel GET
		参数：无

		返回值：List<轮播图片>

	2.搜索 /productGetSerach GET
		参数：
			必选：
			String serach
			Integer start
			Integer size

		返回值：List<产品信息>

	3.添加产品 /productCreate POST
		参数：
			必选：
			String name
			Float price
			Integer type
			String imageaddress
			String introduce

		返回值：0 (添加成功)

ShoppingCart模块：/shoppingCart

	1.得到某人的购物车数据 /shoppingCartGet GET
		参数：
			必选：
			Integer userid

		返回值：List<购物车数据>

	2.创建一条某人的购物车数据 /shoppingCartCreate POST
		参数：
			必选：
			Integer userid
			Integer productid
			Float price
			Integer number

		返回值：0(创建成功)

	3.删除一条某人的购物车数据 /shoppingCartDelete POST
		参数：
			必选：
			Integer id

		返回值：0 (删除成功)