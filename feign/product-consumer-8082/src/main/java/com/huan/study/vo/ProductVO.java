package com.huan.study.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品实体类
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:30
 */
@Data
public class ProductVO {
	private String productId;
	private String productName;
	private BigDecimal productPrice;
	private Integer status;
}
