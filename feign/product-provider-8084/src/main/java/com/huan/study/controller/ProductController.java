package com.huan.study.controller;

import com.huan.study.domain.Product;
import com.huan.study.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
	public Product selectOne(@PathVariable String productId) {
		return productService.selectByProductId(productId);
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

	@PostMapping("addProduct")
	public Map<String, Object> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		Map<String, Object> ret = new HashMap<>(3);
		ret.put("port", port);
		ret.put("applicationName", applicationName);
		ret.put("products", productService.selectAllProducts());
		return ret;
	}

	@PostMapping("updateProduct")
	public Map<String, Object> updateProduct(Product product) {
		productService.updateProduct(product);
		Map<String, Object> ret = new HashMap<>(3);
		ret.put("port", port);
		ret.put("applicationName", applicationName);
		ret.put("products", productService.selectAllProducts());
		return ret;
	}

	@PostMapping("delete")
	public Map<String, Object> delete(String productId) {
		productService.deleteProduct(productId);
		Map<String, Object> ret = new HashMap<>(3);
		ret.put("port", port);
		ret.put("applicationName", applicationName);
		ret.put("products", productService.selectAllProducts());
		return ret;
	}
}
