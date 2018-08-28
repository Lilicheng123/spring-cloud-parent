package com.huan.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试配置的自动属性
 *
 * @author huan.fu
 * @date 2018/6/19 - 10:09
 */
@RestController
@RefreshScope
public class PrintMsgController {

	@Value("${msg}")
	private String msg;

	/**
	 * 打印msg消息
	 *
	 * @return
	 */
	@GetMapping("print/msg")
	public String print() {
		return msg;
	}

}
