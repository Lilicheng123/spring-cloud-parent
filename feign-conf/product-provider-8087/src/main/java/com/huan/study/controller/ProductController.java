package com.huan.study.controller;

import com.huan.study.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品控制器
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:36
 */
@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Value("${server.port}")
	private Integer port;

	@Value("${spring.application.name}")
	private String applicationName;


	@GetMapping("selectOne/{productId}")
	public Map<String, Object> selectOne(@PathVariable String productId, @RequestHeader(value = "token", required = false) String token) {
		Map<String, Object> ret = new HashMap<>(3);
		ret.put("port", port);
		ret.put("applicationName", applicationName);
		ret.put("token", token);
		ret.put("products", productService.selectByProductId(productId));
		return ret;
	}
}
