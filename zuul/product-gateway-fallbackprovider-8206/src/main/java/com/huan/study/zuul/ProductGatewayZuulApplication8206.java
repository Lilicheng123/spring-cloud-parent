package com.huan.study.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 服务网关 zuul
 *
 * @author huan.fu
 * @date 2018/6/8 - 10:26
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ProductGatewayZuulApplication8206 {

	public static void main(String[] args) {
		SpringApplication.run(ProductGatewayZuulApplication8206.class, args);
	}

}
