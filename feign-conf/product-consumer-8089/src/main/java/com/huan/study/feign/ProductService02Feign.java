package com.huan.study.feign;


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
@FeignClient(name = "product-provider-02")
public interface ProductService02Feign {

	/**
	 * PathVariable 注解使用时，必须里面要有值,即@PathVariable("")或@PathVariable(name="")
	 *
	 * @param productId
	 * @return
	 */
	@GetMapping(value = "product/selectOne/{productId}")
	Map<String, Object> selectByProductId(@PathVariable("productId") String productId);

}
