package com.huan.study.conf;

import feign.Logger;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

import java.nio.charset.Charset;

/**
 * 对 spring.application.name=product-provider-01的微服务进行配置
 * feign 默认的配置类 FeignClientsConfiguration
 * <p>
 * 注意：此类如果被spring的上下文扫描到了（加了@Configuration注解），那么就是一个全局的配置，对所有的FeignClient都生效
 *
 * @author huan.fu
 * @date 2018/5/31 - 10:51
 */
@Slf4j
public class EurekaInfoUrlFeignConfiguration {
	/**
	 * 增加 RequestInterceptor 可以添加额外的请求信息，比如请求头，请求参数
	 * 增加一个basic认证的请求头，当某些微服务需要basic认证时，可以使用
	 *
	 * @return
	 */
	@Bean
	public RequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("root", "admin", Charset.forName("utf-8"));
	}

	/**
	 * 修改日志的级别，其余的级别看Logger.Level这个枚举类
	 *
	 * @return
	 */
	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}


}
