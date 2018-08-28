package com.huan.study.eureka.ha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * eureka client 注册到高可用的eureka server 上
 *
 * @author huan.fu
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationClient8766 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationClient8766.class, args);
	}
}
