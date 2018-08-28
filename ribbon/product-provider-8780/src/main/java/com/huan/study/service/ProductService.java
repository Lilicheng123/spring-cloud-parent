package com.huan.study.service;


import com.huan.study.domain.Product;

import java.util.List;

/**
 * 商品服务接口
 *
 * @author huan.fu
 * @date 2018/5/28 - 16:32
 */
public interface ProductService {

	/**
	 * 根据商品编号查询商品
	 *
	 * @param productId
	 * @return
	 */
	Product selectByProductId(String productId);

	/**
	 * 查询所有的商品
	 *
	 * @return
	 */
	List<Product> selectAllProducts();
}
