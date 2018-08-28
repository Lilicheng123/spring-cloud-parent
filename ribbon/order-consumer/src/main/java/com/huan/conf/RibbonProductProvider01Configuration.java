package com.huan.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注意： 此类不可被spring 的主上下文扫描到，否则就是全局配置，对所有的ribbon客户端都会起作用
 * <p>
 * 对 spring.application.name = product-provider-01 进行单独配置
 * 修改对product-provider-01的负载均衡策略为随机访问，不在是默认的轮训访问
 *
 * @author huan.fu
 * @date 2018/5/29 - 11:40
 */
@Configuration
public class RibbonProductProvider01Configuration {

	/**
	 * 设置负载均衡策略为 随机，默认是轮训
	 *
	 * @return
	 */
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}

}
