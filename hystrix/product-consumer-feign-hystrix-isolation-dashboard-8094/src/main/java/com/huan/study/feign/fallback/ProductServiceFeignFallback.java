package com.huan.study.feign.fallback;

import com.google.common.collect.Maps;
import com.huan.study.feign.ProductService01Feign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * feign 的服务降级
 *
 * @author huan.fu
 * @date 2018/6/4 - 10:46
 */
@Slf4j
@Component
public class ProductServiceFeignFallback implements ProductService01Feign {

	@Override
	public Map<String, Object> selectByProductId(String productId) {
		log.info("服务降级....");
		Map<String, Object> ret = Maps.newHashMap();
		ret.put("port", "-1");
		ret.put("msg", "获取商品信息失败,可能是商品微服务出现了问题.");
		return ret;
	}

	@Override
	public Map<String, Object> selectByProductIdAndName(String productId, String productName) {
		log.info("服务降级....");
		Map<String, Object> ret = Maps.newHashMap();
		ret.put("port", "-1");
		ret.put("msg", "获取selectByProductIdAndName失败.");
		return ret;
	}
}
