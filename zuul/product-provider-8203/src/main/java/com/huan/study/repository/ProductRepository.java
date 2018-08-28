package com.huan.study.repository;

import com.huan.study.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品 repository
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:32
 */
public interface ProductRepository extends JpaRepository<Product, String> {
	/**
	 * 根据商品编号和商品名称进行查询
	 *
	 * @param productId
	 * @param productName
	 * @return
	 */
	List<Product> findByProductIdAndAndProductName(String productId, String productName);
}
