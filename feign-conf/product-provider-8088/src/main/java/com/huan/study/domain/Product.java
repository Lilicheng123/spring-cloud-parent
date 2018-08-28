package com.huan.study.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 商品实体类
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:30
 */
@Entity
@Table(name = "product")
@Data
public class Product {
	@Id
	@Column(name = "product_id")
	private String productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_price")
	private BigDecimal productPrice;
	@Column(name = "status")
	private Integer status;
}
