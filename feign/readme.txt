eureka-server
    |- 服务注册中心
feign
    product-provider-8083
    product-provider-8083
        |- 服务提供者
    product-consumer-8082
        |- 服务消费者，使用feign进行调用(演示Feign调用各种方法的参数)


消费端：
    1、启动类上增加 @EnableFeignClients 注解
    2、client 上需要增加 @FeignClient 注解

注意事项：
    @FeignClient注解下的方法注意事项：
		1、@PathVariable注解的使用
			使用这个注解的使用，必须要写里面的name或value的值，即@PathVariable("field"),不写启动报错
		2、返回值可以返回实体类或Map类型等等
		3、@RequestParam注解传递参数的问题
			|- 不存在@RequestParam注解
				>> 请求类型将会变成post请求，即使你在方法上指定为get也不行。这个时候可以存在一个没有带注解的参数
				   ** 示例：
					  1、  @GetMapping("product/selectByProductIdAndName")
						   Map<String, Object> selectByProductIdAndNameMap(Map<String, Object> params);
						   结果：此时是post请求，即使上方加上了@GetMapping注解也会是发送post请求
					  2、  @GetMapping("product/selectByProductIdAndName")
						   Map<String, Object> selectByProductIdAndName(String productId, String productName)
						   结果：程序启动报错，因为存在多个参数没有@RequestParam注解
			|- 存在@RequestParam注解
				>> 不指定value的情况下，必须加载Map类型的参数上，里面的值会附加在url后面
					** 示例：
						1、  @GetMapping("product/selectByProductIdAndName")
							 Map<String, Object> selectByProductIdAndNameMap(@RequestParam Map<String, Object> params);
							 结果：没有指定value,注解加载map类型的参数上
						2、  @GetMapping("product/selectByProductIdAndName")
							 Map<String, Object> selectByProductIdAndName(@RequestParam String productId, String productName);
							 结果：启动报错,没有指定value的值，且参数不是map类型
						3、  @GetMapping("product/selectByProductIdAndName")
							 Map<String, Object> selectByProductIdAndName(@RequestParam("productId") String productId, String productName);
							 结果：由于后面有一个参数没有加上@RequestParam注解，此时这个请求就变成了post请求发送，即使申明的是get请求
						4、  @GetMapping("product/selectByProductIdAndName")
							 Map<String, Object> selectByProductIdAndName(@RequestParam("productId") String productId, @RequestParam("productName") String productName);
							 结果：正常的get请求

			|- 传递对象
				>> 服务提供方在控制层使用的是@RequestBody接收参数
					** 调用方 feignClient 的写法： 直接传递一个对象（默认就是@RequestBody）
						参考：com.huan.study.feign.ProductServiceFeign.addProduct(@RequestBody ProductVO productVO); 此时前面的@RequestBody可以不写
				>> 服务提供方没有使用@RequestBody进行接收
					** 调用方 feignClient 的写法： 需要传递一个Map
						参考：com.huan.study.feign.ProductServiceFeign.updateProduct(@RequestParam Map<String,Object> params);
							1、需要以Map的参数传递
							2、@RequestParam注解不可少