package com.huan.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 服务配置中心
 *
 * @author huan.fu
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ApplicationConfigServerBus8305 {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfigServerBus8305.class, args);
	}
}
