package com.huan.study.conf;

import feign.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

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
public class ProductService01FeignConfiguration {
	/**
	 * 重试
	 *
	 * @return
	 */
	@Bean
	public Retryer feignRetry() {
		return new Retryer.Default();
	}

	/**
	 * 设置请求的连接和处理的超时时间
	 *
	 * @return
	 */
	@Bean
	public Request.Options feignRequestOptions() {
		return new Request.Options(10000, 60000);
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

	/**
	 * 使用feign默认的契约，而不是使用spring mvc的契约
	 * 注意： 此时ProductService01Feign类上的方法的写法发生了改变
	 *
	 * @return
	 */
	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}


	/**
	 * 添加一个请求拦截器：增加一个自定义的请求头token=1234567890
	 *
	 * @return
	 */
	@Bean
	public RequestInterceptor tokenRequestInterceptor() {
		return template -> template.header("token", "1234567890");
	}


}
