package com.huan.study.feign;


import com.huan.study.feign.fallback.ProductServiceFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * 商品服务接口
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:32
 */
@FeignClient(name = "product-provider-zipkin-8501", fallback = ProductServiceFeignFallback.class)
public interface ProductService01Feign {

	/**
	 * 调用商品微服务，返回商品信息
	 *
	 * @param productId
	 * @return
	 * @RequestLine 注解使用时，feign的注解
	 */
	@GetMapping("/product/selectOne/{productId}")
	Map<String, Object> selectByProductId(@PathVariable("productId") String productId);
}
