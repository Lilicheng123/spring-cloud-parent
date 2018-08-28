package com.huan.study.eureka.ha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka server ha 8765
 *
 * @author huan.fu
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationHaServer8765 {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationHaServer8765.class, args);
	}
}
