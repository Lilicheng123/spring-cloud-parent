package com.huan.study.service;


import com.huan.study.domain.Product;

import java.util.List;

/**
 * 商品服务接口
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:32
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
	 * 根据商品编号和商品名称进行查询
	 *
	 * @param productId
	 * @param productName
	 * @return
	 */
	List<Product> selectByProductIdAndName(String productId, String productName);

	/**
	 * 查询所有的商品
	 *
	 * @return
	 */
	List<Product> selectAllProducts();

	/**
	 * 添加商品
	 *
	 * @param product
	 */
	void addProduct(Product product);

	/**
	 * 修改商品
	 *
	 * @param product
	 */
	void updateProduct(Product product);

	/**
	 * 删除商品
	 *
	 * @param productId
	 */
	void deleteProduct(String productId);
}
