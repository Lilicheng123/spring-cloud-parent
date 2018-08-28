package com.huan.study.controller;

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
@RequestMapping("product02")
public class Product02Controller {

	@Autowired
	private ProductService02Feign productServiceFeign;

	/**
	 * @param productId
	 * @return
	 */
	@GetMapping("selectOne/{productId}")
	public Map<String, Object> selectByProductId(@PathVariable String productId) {
		return productServiceFeign.selectByProductId(productId);
	}

}
