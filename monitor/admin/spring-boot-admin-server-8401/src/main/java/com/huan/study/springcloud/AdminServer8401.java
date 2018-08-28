package com.huan.study.springcloud;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * spring boot admin 监控服务端
 *
 * @author huan.fu
 * @date 2018/6/20 - 11:05
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class AdminServer8401 {

	public static void main(String[] args) {
		SpringApplication.run(AdminServer8401.class, args);
	}

}
