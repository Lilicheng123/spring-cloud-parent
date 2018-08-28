前置条件：
    eureka-server
        |- 服务注册中心
    feign-conf
        product-provider-8085
        product-provider-8086
        product-provider-8087
        product-provider-8088
            |- 上方四个工程代码是一模一样的，8085和8086一组,spring.application.name=product-provider-01
                                         8087和8088一组,spring.application.name=product-provider-02
                模拟2种不同的微服务
        product-consumer-8089
            |- 服务消费者，使用feign调用上面的微服务

实现的功能：
    1、单独对某个客户端修改配置
        @FeignClient中configuration指定的配置文件不可被spring的上下文扫描到，否则就是全局配置，对所有的客户端都会生效
    2、修改默认的契约
        默认的契约是spring mvc契约，此处修改成默认的，需要注意写法的不同。
    3、修改feign的日志级别
        1、定义Logger.Level的配置Bean
        2、在配置文件中将我们自己写的feign接口所在的包的日志级别修改成debug
    4、根据url直接进行调用，和增加自定义请求头
        1、@FeignClient 中的name的值需要唯一，可以随便写
        2、url 的值可以写绝对地址或主机名
        3、增加RequestInterceptor的实例
        4、调用系统中的eureka服务，返回eureka服务的信息，因为系统中的eureka访问需要basic认证，所以此处需要增加一个请求头
        5、如果我们想要在 RequestInterceptor 中使用ThreadLocal变量的值，应该在feign中禁用hysitrx或者将隔离策略改成信号量隔离
    5、增加压缩
        我们当前使用的版本(Edgware.SR3)需要引入ok-http,不然程序启动不了
        如果发现feign的压缩没有起作用，那么需要开启spring boot的压缩，即增加server.compression.enabled=true等等
    6、增加超时时间的配置
        1、全局超时时间的配置
        2、对单个客户端超时时间的配置
    7、配置重试
        注入 Retryer 这个Bean
    8、和 hystrix fallback 配置使用(略,到时候和hystrix集成时在加上)
    9、使用feign的配置文件完成部分上面的功能
        1、见application.yml中的写法
        2、当key为default时表示的是全局的配置，为具体的spring.application.name的值时，就是单独为这个客户端进行配置


