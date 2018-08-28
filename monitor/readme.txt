spring-boot-admin-server-8401
    |- 搭建 admin server
       >> 在 spring boot 1.5.x 后，要监控端点，需要management.security.enabled=false
       >> 引入 spring security 后，就可以使用 spring security 保护admin server
       >> 引入 spring security 保护admin server
       >> 作为一个服务发现者注册到 eureka 上
       >> 给 admin server 提供一个表单登录
       >> 服务的下上线进行邮件的通知
            1、引入邮件依赖
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-mail</artifactId>
                </dependency>
            2、配置文件中进行邮件参数的配置
                spring:
                  application:
                    name: spring-boot-admin-server
                  boot:
                    admin:
                      context-path: /admin
                  mail:
                    default-encoding: UTF-8
                    host: smtp.exmail.qq.com
                    password: 邮箱用户名
                    username: 邮箱密码
                    properties:
                      mail:
                        smtp:
                          auth: true
                          starttls:
                            enable: true
                            required: true
            3、编写发送类
                NotifierConfiguration （在具体的发送逻辑中可以进行别的处理，不一定非要发送邮件）


client-product-provider-8402
    |- 搭建 admin client (就是一个普通的spring cloud程序)
       >> 动态控制日志级别
            logback-spring.xml
            <?xml version="1.0" encoding="UTF-8"?>
            <configuration>
              <include resource="org/springframework/boot/logging/logback/base.xml"/>
              <jmxConfigurator/>
            </configuration>
       >> 当设置了management.context-path，如何进行配置
            eureka:
              instance:
                metadata-map:
                  management.context-path: /manager
       >> 显示版本号
             <build>
                <plugins>
                    <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                        <executions>
                            <execution>
                                <goals>
                                    <goal>build-info</goal>
                                </goals>
                            </execution>
                        </executions>
                    </plugin>
                </plugins>
            </build>
       >> 客户端使用了 spring security 做了权限保护，admin server如何访问
            1、在 spring security 中启用 basic 认证
            2、在eureka 的 matedata-map 中设置 basic认证的用户名和密码，指的是登录客户端的用户名和密码
       >> 整合 hystrix ui
            1、引入依赖
                <dependency>
                    <groupId>de.codecentric</groupId>
                    <artifactId>spring-boot-admin-server-ui-hystrix</artifactId>
                    <version>1.5.5</version>
                </dependency>
            2、添加一个新的路由端点
                spring.boot.admin.routes.endpoints: env,metrics,dump,jolokia,info,configprops,trace,logfile,refresh,flyway,liquibase,heapdump,loggers,auditevents,hystrix.stream

zipkin
    product-provider-zipkin-8501
    product-consumer-feign-hystrix-zipkin-8502
        1、引入以下依赖
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-sleuth</artifactId>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-sleuth-zipkin</artifactId>
            </dependency>
        2、application.yml 配置文件
            spring:
              sleuth:
                sampler:
                  percentage: 1 # 抽象存取的比例，默认是 0.1(10%)
              zipkin:
                base-url: http://zipkin-server-8503/  #zipkin server 所在的地址
    zipkin-server-8503
        1、引入一下依赖
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            </dependency>
            <dependency>
                <groupId>io.zipkin.java</groupId>
                <artifactId>zipkin-server</artifactId>
            </dependency>
            <dependency>
                <groupId>io.zipkin.java</groupId>
                <artifactId>zipkin-autoconfigure-ui</artifactId>
            </dependency>
            <dependency>
                <groupId>io.zipkin.java</groupId>
                <artifactId>zipkin-autoconfigure-storage-mysql</artifactId>
            </dependency>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
            </dependency>
        2、启动类增加 @EnableZipkinServer 注解
        3、application.yml 配置文件中的配置
                spring:
                  application:
                    name: zipkin-server-8503
                  sleuth:
                    enabled: false # 表示当前程序不使用 sleuth

                zipkin:
                  storage:
                    type: mysql #表示zipkin数据存储方式是mysql
                    mysql:
                      host: localhost
                      port: 3306
                      db: zipkin
                      username: root
                      password: w123456
        4、执行 zipkin-storage-mysql-version.jar 包中的 mysql.sql 文件