eureka-server
    |- 服务注册中心
    zuul
        product-provider-8202
        product-provider-8203
            |- 服务提供者
        product-consumer-8201
            |- 服务消费者
        product-gateway-8204
            |- 网关程序，演示网关路由的各种配置
        product-gateway-filters-8205
            |- 网关程序，演示 过滤器 的使用
            |- 禁用过滤器
        product-gateway-fallbackprovider-8206
            |- zuul 服务路由的回退   针对的是单个微服务的回退，比如针对的是 product-provider 或 product-consumer-8201 等这一整个的回退。
            |- 单个服务回退 getRoute() 直接返回那个服务的serviceId的值，为所有的回退，直接返回 null 或 *
        product-gateway-aggregation-swagger2-8207
            |- 聚合 各个工程的 swagger api 文档

RequestContext  ==> zuul 中的Request Context 用于请求中数据的传递，数据使用ThreadLocal中获取的。

过滤器的禁用语法：
    zuul.<SimpleClassName>.<filterType>.disable=true

    比如：
        zuul.SendErrorFilter.error.disable = true 那么 SendErrorFilter 这个过滤器就被禁用了。


默认情况下，zuul 会代理所有注册到Eureka Server上的微服务，并且zuul的路由规则如下：
    http://zuul_host:zuul_port/微服务在eureka上的serverId/** ===> 转发到具体的微服务上


The configuration property zuul.max.host.connections has been replaced by two new properties, zuul.host.maxTotalConnections and zuul.host.maxPerRouteConnections which default to 200 and 20 respectively.
