package com.huan.study.service.impl;

import com.huan.study.domain.Product;
import com.huan.study.repository.ProductRepository;
import com.huan.study.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品service实现
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:34
 */
@Slf4j
@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product selectByProductId(String productId) {
		log.info("根据商品编号:[{}]查询商品信息.", productId);
		return productRepository.findOne(productId);
	}

	@Override
	public List<Product> selectByProductIdAndName(String productId, String productName) {
		return productRepository.findByProductIdAndAndProductName(productId, productName);
	}

	@Override
	public List<Product> selectAllProducts() {
		return productRepository.findAll();
	}
}
