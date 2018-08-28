eureka-server
    |- 服务注册中心
    config
        config-bus-webhook
            config-server-bus-8305
                |- config server 服务端，整合 spring cloud bus,实现配置的自动刷新
            product-provider-config-client-bus-webhook-8303
            product-provider-config-client-bus-webhook-8304
                |- config client 客户端，整合 spring cloud bus

        config-server-8301
            |- config server 的服务端
        product-provider-config-client-8302
            |- config client 端

config server 端配置
    server 端高可用
        |- 注册到了 eureka 上
        |- 没有注册到 eureka 上



    在传统的应用中，我们的配置文件都是放在这个项目中，这个影响不大。但是在一个微服务架构的系统中，我们的微服务可能存在几十上百个，并且每个小的微服务可能又部署在多台机器上，那么这个时候如果我们的配置文件在都放在
具体的微服务中，那么就不好进行维护了，因此我们需要将服务中的配置文件单独抽取出来，集中管理。spring cloud config 可以为我们做到配置的集中管理，动态刷新配置等。当然除了spring cloud config 还有其它的也可以实现
配置的集中管理，此处简单的来看一下 spring cloud config 的配置。

实现功能
    1、config server 端的编写并注册到eureka上
    2、config server 端增加 basic 认证
    3、config server 路径查找,searchPaths 参数
    4、配置项进行对称加密处理
    5、其它的一些配置见具体的配置文件上
    6、客户端的快速失败
    7、config server 的一些加密和解密端点


配置的动态刷新：
    一、安装erlang 和 rabbitmq  需要注意 erlang和rabbitmq的版本需要匹配上
    二、config client 需要引入 bus-amqp 依赖
    三、需要刷新的配置上增加 @RefreshScope 注解
    四、git 仓库 webhook的配置




