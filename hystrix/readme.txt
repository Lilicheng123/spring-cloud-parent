eureka-server
    |- 服务注册中心
hystrix
    product-provider-8091
    product-provider-8092
        |- 服务提供者
    product-consumer-feign-hystrix-8093
        |- feign 和 hystrix的整合
            主类上增加@EnableCircuitBreaker注解
            yml文件中增加 feign.hystrix.enabled=true
            pom文件中 引入 feign和hystrix的依赖
    product-consumer-feign-hystrix-isolation-dashboard-8094
        |- 隔离策略的修改，全局配置和单独为某个方法进行配置
            hystrix.command.default  # 这个前缀的为全局配置
            hystrix.command.commandKey # 这个前缀为局部配置，即单独为这个方法进行配置   commandKey格式 ： 类名#方法名(参数类型...)
            eg:
                hystrix:
                  command:
                    default: # 表示全局配置
                      execution:
                        isolation:
                          strategy: SEMAPHORE # 修改默认的隔离策略为信号量隔离
                    ProductService01Feign#selectByProductIdAndName(String,String):  # 为某个方法单独配置隔离策略 格式： 类名#方法名(参数类型...)
                       execution:
                         isolation:
                           strategy: THREAD # 修改默认的隔离策略为线程池隔离
        |- fallback方法最大调用并发的配置
        |- 单机hystrix的监控
        |- 修改feign默认使用HttpUrlConnection，改成apache 的 httpClient 进行调用

注意：
    1、进入fallback方法并不意味者断路器一定是打开的，请求失败、超时、被拒绝以及断路器打开时都会执行回退逻辑。
    2、如果不知道 commandKey 的值，可以在 HystrixCommandProperties 这个类的构造方法中打一个断点，然后看HystrixCommandKey的值

hystrix中推荐使用线程池隔离


