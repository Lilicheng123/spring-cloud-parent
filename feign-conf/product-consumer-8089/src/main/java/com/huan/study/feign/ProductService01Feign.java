package com.huan.study.feign;


import com.huan.study.conf.ProductService01FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.Map;

/**
 * 商品服务接口
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:32
 */
@FeignClient(name = "product-provider-01", configuration = ProductService01FeignConfiguration.class)
public interface ProductService01Feign {

	/**
	 * @RequestLine 注解使用时，feign的注解
	 *
	 * @param productId
	 * @return
	 */
	@RequestLine("GET /product/selectOne/{productId}")
	Map<String, Object> selectByProductId(@Param("productId") String productId);
}
