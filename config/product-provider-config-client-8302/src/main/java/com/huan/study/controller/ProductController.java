package com.huan.study.controller;

import com.huan.study.domain.Product;
import com.huan.study.service.ProductService;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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
	public Map<String, Object> selectOne(@PathVariable String productId) {
		Map<String, Object> ret = new HashMap<>(3);
		ret.put("port", port);
		ret.put("applicationName", applicationName);
		ret.put("products", productService.selectByProductId(productId));
		ret.put("productId", MDC.get("productId"));
		return ret;
	}

	@GetMapping("selectByProductIdAndName")
	public Map<String, Object> selectByProductIdAndName(String productId, String productName) {
		Map<String, Object> ret = new HashMap<>(3);
		ret.put("port", port);
		ret.put("applicationName", applicationName);
		ret.put("products", productService.selectByProductIdAndName(productId, productName));
		return ret;
	}

	@GetMapping("selectAll")
	public List<Product> selectAll() {
		return productService.selectAllProducts();
	}

}
