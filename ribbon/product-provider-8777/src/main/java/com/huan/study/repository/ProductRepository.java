package com.huan.study.repository;

import com.huan.study.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品 repository
 *
 * @author huan.fu
 * @date 2018/5/28 - 16:32
 */
public interface ProductRepository extends JpaRepository<Product, String> {
}
