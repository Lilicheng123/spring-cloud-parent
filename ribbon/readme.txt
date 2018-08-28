eureka-server(服务注册中心)
ribbon（用于测试ribbon）
    product-provider-8777(服务提供者)
    product-provider-8778(服务提供者)
    product-provider-8779(服务提供者)
    product-provider-8780(服务提供者)
    order-consumer(消费者)

product-provider-8777,product-provider-8778 ===> spring.application.name = product-provider-01
product-provider-8779,product-provider-8780 ===> spring.application.name = product-provider-02

product-provider-%s
    |- 此工程就是一个正常的spring boot工程，里面存在一个接口返回商品信息，同时返回端口和application name的值，便于消费端观察

order-consumer
    1、对 product-provider-01 的访问修改负载均衡策略为【随机访问】。
    2、对 product-provider-02 的访问修改负载均衡策略为【轮训访问】，默认就是这个，不用修改。