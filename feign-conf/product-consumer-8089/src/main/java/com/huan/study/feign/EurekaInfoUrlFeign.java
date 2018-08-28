package com.huan.study.feign;


import com.huan.study.conf.EurekaInfoUrlFeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 商品服务接口
 *
 * @author huan.fu
 * @date 2018/5/30 - 16:32
 */
@FeignClient(name = "product-provider-01-url", url = "http://localhost:8761",
		configuration = EurekaInfoUrlFeignConfiguration.class)
public interface EurekaInfoUrlFeign {

	/**
	 * 请求eureka的信息,这个信息是需要 basic 认证的
	 *
	 * @return
	 */
	@GetMapping("/")
	String eurekaInfo();

}
