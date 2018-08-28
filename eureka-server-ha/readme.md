### eureka server 高可用  
比如存在3个eureka server 节点
节点一： 需要注册到 节点二和节点三上  
节点二： 需要注册到 节点一和节点三上
节点三： 需要注册到 节点一和节点节点二上  

eureka server ha 时 eureka server 之间的spring.application.name的值必须要一致  
在测试时发现prefer-ip-address的值需要改成false,不然节点会进入unavailable-replicas这个里面

### eureka client 端的配置  
客户端的url 需要完全写上eureka server的url,不写也是没有问题的。  


多个节点中间以 , 进行隔开。  

