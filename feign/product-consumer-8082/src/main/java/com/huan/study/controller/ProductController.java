package com.huan.study.controller;

import com.google.common.collect.Maps;
import com.huan.study.feign.ProductServiceFeign;
import com.huan.study.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品控制器
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:52
 */
@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductServiceFeign productServiceFeign;

	/**
	 * @param productId
	 * @return
	 */
	@GetMapping("selectOne/{productId}")
	public ProductVO selectByProductId(@PathVariable String productId) {
		return productServiceFeign.selectByProductId(productId);
	}

	@GetMapping("selectByProductIdAndNameMap")
	public Map<String, Object> selectByProductIdAndNameMap(String productId, String productName) {
		Map<String, Object> params = Maps.newHashMap();
		params.put("productId", productId);
		params.put("productName", productName);
		return productServiceFeign.selectByProductIdAndNameMap(params);
	}


	@GetMapping("selectByProductIdAndName")
	public Map<String, Object> selectByProductIdAndName(String productId, String productName) {
		return productServiceFeign.selectByProductIdAndName(productId, productName);
	}

	@PostMapping("addProduct")
	public Map<String, Object> addProduct(@RequestBody ProductVO productVO) {
		return productServiceFeign.addProduct(productVO);
	}

	@PostMapping("updateProduct")
	public Map<String, Object> updateProduct(ProductVO productVO) {
		Map<String, Object> params = new HashMap<>(4);
		params.put("productId", productVO.getProductId());
		params.put("productName", productVO.getProductName());
		params.put("productPrice", productVO.getProductPrice());
		params.put("status", productVO.getStatus());

		return productServiceFeign.updateProduct(params);
	}

	@PostMapping("delete")
	public Map<String, Object> delete(String productId) {
		return productServiceFeign.delteProduct(productId);
	}
}
