package com.huan.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 商品微服务
 *
 * @author huan.fu
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationProductProviderConfigClientBusWebhook8304 {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationProductProviderConfigClientBusWebhook8304.class, args);
	}
}
