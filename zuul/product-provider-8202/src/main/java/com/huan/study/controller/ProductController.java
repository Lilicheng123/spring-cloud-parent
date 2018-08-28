package com.huan.study.controller;

import com.huan.study.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品控制器
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:36
 */
@RestController
@RequestMapping("product")
@Api(value = "商品提供者", tags = "商品提供者")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Value("${server.port}")
	private Integer port;

	@Value("${spring.application.name}")
	private String applicationName;

	@ApiImplicitParam(name = "productId", value = "商品编号", defaultValue = "p0001", required = true, dataType = "String", paramType = "path")
	@ApiOperation("根据商品编号查询商品")
	@GetMapping("selectOne/{productId}")
	public Map<String, Object> selectOne(@PathVariable String productId, HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<>(3);
		ret.put("port", port);
		ret.put("applicationName", applicationName);
		ret.put("products", productService.selectByProductId(productId));
		ret.put("token", request.getHeader("token"));
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			ret.put("cookies", Arrays.stream(cookies).collect(Collectors.toMap(Cookie::getName, Cookie::getValue)));
		} else {
			ret.put("cookies", "没有cookies");
		}
		return ret;
	}

}
