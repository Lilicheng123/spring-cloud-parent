package com.huan.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 商品微服务
 *
 * @author huan.fu
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories
public class ApplicationProductProvider8088 {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationProductProvider8088.class, args);
	}
}
