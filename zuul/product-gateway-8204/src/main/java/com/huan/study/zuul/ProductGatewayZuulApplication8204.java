package com.huan.study.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.post.LocationRewriteFilter;
import org.springframework.context.annotation.Bean;

/**
 * 服务网关 zuul
 *
 * @author huan.fu
 * @date 2018/6/8 - 10:26
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ProductGatewayZuulApplication8204 {

	/**
	 * 重写 Location 头
	 *
	 * @return
	 */
	@Bean
	public LocationRewriteFilter locationRewriteFilter() {
		return new LocationRewriteFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductGatewayZuulApplication8204.class, args);
	}

}
