package com.huan.study.controller;

import com.huan.study.feign.ProductServiceFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

/**
 * 商品控制器
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:52
 */
@RestController
@RequestMapping("product")
@Api(tags = "商品消费者", value = "商品消费者")
public class ProductController {

	@Autowired
	private ProductServiceFeign productServiceFeign;

	/**
	 * 根据商品编号远程调用商品提供者返回商品信息
	 *
	 * @param productId
	 * @return
	 */
	@ApiImplicitParam(name = "productId", value = "商品编号", defaultValue = "p0001", required = true, dataType = "String", paramType = "path")
	@ApiOperation("根据商品编号查询商品")
	@GetMapping("selectOne/{productId}")
	public Map<String, Object> selectByProductId(@PathVariable String productId, HttpServletRequest request) {

		Optional.ofNullable(request.getCookies()).ifPresent(cookies -> Arrays.stream(cookies).map(Cookie::getName).forEach(System.out::println));

		return productServiceFeign.selectByProductId(productId);
	}
}
