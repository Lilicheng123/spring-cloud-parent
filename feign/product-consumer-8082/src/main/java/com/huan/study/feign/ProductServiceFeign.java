package com.huan.study.feign;


import com.huan.study.vo.ProductVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 商品服务接口
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:32
 */
@FeignClient(name = "product-provider")
public interface ProductServiceFeign {

	/**
	 * PathVariable 注解使用时，必须里面要有值,即@PathVariable("")或@PathVariable(name="")
	 *
	 * @param productId
	 * @return
	 */
	@GetMapping("product/selectOne/{productId}")
	ProductVO selectByProductId(@PathVariable("productId") String productId);

	/**
	 * 去掉 @RequestParam 注解将变成post请求,加上为get请求
	 *
	 * @param params
	 * @return
	 */
	@GetMapping("product/selectByProductIdAndName")
	Map<String, Object> selectByProductIdAndNameMap(@RequestParam Map<String, Object> params);

//	程序启动报错，存在多个参数没有@requestParam注解
//	@GetMapping("product/selectByProductIdAndName")
//	Map<String, Object> selectByProductIdAndName(String productId, String productName);

//  程序启动报错，没有指定value的值，且参数不是map
//	@GetMapping("product/selectByProductIdAndName")
//	Map<String, Object> selectByProductIdAndName(@RequestParam String productId, String productName);

//  由于后面有一个参数没有加上@RequestParam注解，此时这个请求就变成了post请求发送，即使申明的是get请求
//	@GetMapping("product/selectByProductIdAndName")
//	Map<String, Object> selectByProductIdAndName(@RequestParam("productId") String productId, String productName);

	@GetMapping("product/selectByProductIdAndName")
	Map<String, Object> selectByProductIdAndName(@RequestParam("productId") String productId, @RequestParam("productName") String productName);

	@PostMapping("product/addProduct")
	Map<String, Object> addProduct(@RequestBody ProductVO productVO);

	@PostMapping("product/updateProduct")
	Map<String, Object> updateProduct(@RequestParam Map<String, Object> params);

	@PostMapping("product/delete")
	Map<String, Object> delteProduct(@RequestParam("productId") String productId);

}
