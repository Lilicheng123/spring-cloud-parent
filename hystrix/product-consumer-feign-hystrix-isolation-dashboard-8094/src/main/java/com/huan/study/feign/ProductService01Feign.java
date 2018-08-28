package com.huan.study.feign;


import com.huan.study.feign.fallback.ProductServiceFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 商品服务接口
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:32
 */
@FeignClient(name = "product-provider", fallback = ProductServiceFeignFallback.class)
public interface ProductService01Feign {

	/**
	 * 调用商品微服务，返回商品信息-  隔离策略为线程隔离
	 *
	 * @param productId
	 * @return
	 * @RequestLine 注解使用时，feign的注解
	 */
	@GetMapping("/product/selectOne/{productId}")
	Map<String, Object> selectByProductId(@PathVariable("productId") String productId);

	/**
	 * 调用商品微服务，返回商品信息-  隔离策略为信号量隔离
	 *
	 * @param productId
	 * @param productName
	 * @return
	 */
	@GetMapping("/product/selectByProductIdAndName")
	Map<String, Object> selectByProductIdAndName(@RequestParam("productId") String productId,
												 @RequestParam("productName") String productName);
}
