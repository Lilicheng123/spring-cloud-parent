package com.huan.study.feign.fallback;

import com.google.common.collect.Maps;
import com.huan.study.feign.ProductService02Feign;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * feign 的降级，使用FallBackFactory获取引起降级的原因
 *
 * @author huan.fu
 * @date 2018/6/4 - 10:46
 */
@Slf4j
@Component
public class ProductServiceFeignFallbackFactory implements FallbackFactory<ProductService02Feign> {
	@Override
	public ProductService02Feign create(Throwable cause) {
		return new ProductService02Feign() {
			@Override
			public Map<String, Object> selectByProductId(String productId) {
				Map<String, Object> ret = Maps.newHashMap();
				ret.put("code", "-1");
				ret.put("出错原因", cause.getMessage());
				return ret;
			}
		};
	}
}
