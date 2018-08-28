package com.huan.study.controller;

import com.huan.study.feign.ProductService01Feign;
import com.huan.study.feign.ProductService02Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 商品控制器
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:52
 */
@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private ProductService01Feign productService01Feign;

	@Autowired
	private ProductService02Feign productService02Feign;

	/**
	 * 获取商品信息
	 *
	 * @param productId
	 * @return
	 */
	@GetMapping("/01/selectOne/{productId}")
	public Map<String, Object> select01ByProductId(@PathVariable String productId) {
		return productService01Feign.selectByProductId(productId);
	}

	/**
	 * 获取商品信息
	 *
	 * @param productId
	 * @return
	 */
	@GetMapping("/02/selectOne/{productId}")
	public Map<String, Object> select02ByProductId(@PathVariable String productId) {
		return productService02Feign.selectByProductId(productId);
	}
}
