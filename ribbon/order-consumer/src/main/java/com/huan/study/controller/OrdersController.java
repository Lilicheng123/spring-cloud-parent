package com.huan.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 订单控制器
 *
 * @author huan.fu
 * @date 2018/5/28 - 16:52
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 创建订单
	 *
	 * @param productId
	 * @return
	 */
	@GetMapping("create/{providerId}/{productId}")
	public Map<String, Object> createOrders(@PathVariable String providerId, @PathVariable String productId) {
		return restTemplate.getForObject("http://product-provider-" + providerId + "/product/selectOne/" + productId, Map.class);
	}

}
