package com.huan.study.zuul.controller;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 测试本地跳转
 *
 * @author huan.fu
 * @date 2018/6/12 - 11:49
 */
@RestController
public class LocalForwardController {

	@Value("${server.port}")
	private Integer port;

	@GetMapping("product/local/forward")
	public Map<String, Object> localForward(HttpServletRequest request) {
		Map<String, Object> ret = Maps.newHashMap();
		ret.put("port", port);
		ret.put("productId", "商品编号");
		ret.put("productName", "商品名称");
		ret.put("productPrice", "商品价格");
		ret.put("status", "状态");
		ret.put("queryString", request.getQueryString());
		return ret;
	}

}
