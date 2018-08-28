package com.huan.study.conf;

import com.huan.conf.RibbonProductProvider01Configuration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Component;

/**
 * 对 spring.application.name = product-provider-01 进行单独配置
 * 修改对product-provider-01的负载均衡策略为随机访问，不在是默认的轮训访问
 *
 * @author huan.fu
 * @date 2018/5/29 - 11:40
 */
@RibbonClient(name = "product-provider-01", configuration = RibbonProductProvider01Configuration.class)
@Component
public class RibbonProductProvider01Conf {

}
