eureka-server
    |- 服务注册中心
    hystrix-dashboard-turbine
        |- hystrix-dashboard
            |- 完成单个服务消费者的监控
        |- hystrix-single-cluster-turbine
        |- hystrix-more-cluster-turbine
        |- hystrix-all-cluster-turbine

hystrix-dashboard-turbine
    1、加入pom依赖
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
        </dependency>
    2、启动类上增加注解
        @EnableHystrixDashboard
    3、访问：
        1、访问dashboard页面： http://localhost:8097  8097为dashboard工程的端口
        2、输入： http://localhost:3333/hystrix.stream 监控服务消费者 3333为消费端8096端口所在的应用程序，要写成3333是因为8096程序修改了manager.port的值
        3、http://localhost:3333/hystrix.stream 访问有问题(因为有可能被注释了)，就改成http://localhost:8096/hystrix.stream


hystrix-single-cluster-turbine
    product-provider-8098
        |- 服务提供者
    product-consumer-8099
    product-consumer-8100
        >> 需要加入hystrix
        >> 需要配置 eureka.instance.metadata-map.cluster: 一个具体的值
    product-hystrix-turbine-dashboard-8101
        >> 需要添加 dashboard 和 turbine 依赖
        >> 配置文件的配置
            turbine:
              app-config: product-consumer  # 指定了需要收集监控信息的服务名，即spring.application.name的值
              aggregator:
                cluster-config: PRODUCT #集群的名字的列表，和存在hystrix工程中的eureka.instance.metadata-map.cluster值对应
              combine-host-port: true # 为true表示可以让同一主机上的服务通过主机名和端口号的组合来进行区分
              cluster-name-expression: metadata['cluster'] # 用来区分不同的聚合集群，metadata['cluster']表示从eureka.instance.metadata-map中获取cluster的值

hystrix-more-cluster-turbine
    product-consumer-8102
    order-consumer-8104
    product-consumer-8103
        |- 服务消费者
             >> 需要加入 hystrix
             >> 需要配置 eureka.instance.metadata-map.cluster: 一个具体的值
    product-hystrix-turbine-dashboard-8106
        turbine:
          app-config: product-consumer,order-consumer  # 聚合多个服务，中间以逗号分隔
          aggregator:
            cluster-config: PRODUCT  # 和服务消费者中的 eureka.instance.metadata-map.cluster 值对应
          combine-host-port: true
          cluster-name-expression: metadata['cluster']  # 获取的是服务消费者的元数据中的 cluster 的值
    product-provider-8105
        |- 服务提供者

hystrix-all-cluster-turbine
    order-consumer-8106
    product-consumer-8107
    product-consumer-8108
        |- 服务消费者
           >> 不用配置 eureka.instance.metadata-map.cluster 的值
    product-hystrix-turbine-dashboard-8110
        turbine:
          app-config: product-consumer,order-consumer  # 聚合多个服务，中间以逗号分隔
          combine-host-port: true
          cluster-name-expression: "'default'"      # 值改成 default
        不需要配置  turbine.aggregator.cluster-config 的值
    product-provider-8109

