package com.huan.springcloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * zipkin server 端
 *
 * @author huan.fu
 * @date 2018/6/22 - 10:56
 */
@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class ZipkinServer8503Application {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServer8503Application.class, args);
	}

}
