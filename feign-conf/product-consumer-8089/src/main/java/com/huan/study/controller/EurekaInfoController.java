package com.huan.study.controller;

import com.huan.study.feign.EurekaInfoUrlFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取eureka的信息
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:52
 */
@RestController
@RequestMapping("eureka")
public class EurekaInfoController {

	@Autowired
	private EurekaInfoUrlFeign eurekaInfoUrlFeign;

	@GetMapping("info")
	public String selectByProductId() {
		return eurekaInfoUrlFeign.eurekaInfo();
	}
}