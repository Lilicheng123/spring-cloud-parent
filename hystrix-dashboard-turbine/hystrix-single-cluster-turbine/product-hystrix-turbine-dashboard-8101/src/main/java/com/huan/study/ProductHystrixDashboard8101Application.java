package com.huan.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 商品微服务
 *
 * @author huan.fu
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableTurbine
public class ProductHystrixDashboard8101Application {
	public static void main(String[] args) {
		SpringApplication.run(ProductHystrixDashboard8101Application.class, args);
	}
}
