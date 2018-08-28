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
public class ApplicationProductProviderConfigClient8302 {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationProductProviderConfigClient8302.class, args);
	}
}
