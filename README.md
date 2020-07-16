# Spring Boot - Spring Cloud
> 一个基于Spring Boot、Spring Cloud的项目，用来快速搭建电商项目微服务骨架。
说明：所有的功能都没有做参数强校验，也不考虑各种异常情况，在入参完整的情况下能够跑通流程。

##### 姊妹文章：[JavaEE 电商系统微服务开发骨架（dubbo版）](https://mp.weixin.qq.com/s/Fk0h5ba0pLE7KXLGkK4gfQ)

> 当你选择微服务架构时，可以选择Dubbo, 也可以选择Spring Cloud。

### 功能介绍：
- 基于Spring Cloud Eureka 的服务注册，服务发现。
- 分为商品微服务，用户微服务，交易微服务。
- 统一的的gateway，包括签名，统一输出，统一异常。

### Require Components
- MySQL5.6+

#### Done
- 集成Spring Boot(2.2.8.RELEASE)
- 整合Mybatis, Mybatis Generator
- 整合SpringCloud(Hoxton.SR6)
- 整合Hystrix
- 整合Zuul
- 整合ZipKin
- Maven多模块
- 整合Response统一输出，方便Controller层使用
- 拆分多个系统discover, item, order, user, zuul等

### Todo
- 登录模块(OAuth2.0, JWT等)
- 配置中心（Diamond/Apollo)

### Application Port

Application | Port |    
-:|-:|
service-discover | 8260 |
user-service | 2100 |
item-service | 2200 |
order-service | 2300 |
gateway-service | 2000 |
hystrix-dashboard | 2001 |
zuul-server | 2002 |
config-server | 2003 |
zipkin-server | 2004 |


### Run Application
1. 新建数据库：intecsec_springboot
2. 导入database目录中的intecsec_springboot.sql到数据库
3. maven打包，然后执行jar包
``` shell
mvn clean install
java -jar service-discover/target/service-discover-1.0-SNAPSHOT.jar

java -jar mall-user/target/mall-user-1.0-SNAPSHOT.jar
java -jar mall-item/target/mall-item-1.0-SNAPSHOT.jar
java -jar mall-order/target/mall-order-1.0-SNAPSHOT.jar
java -jar mall-gateway/target/mall-gateway-1.0-SNAPSHOT.jar
java -jar mall-gateway/target/mall-zuul-1.0-SNAPSHOT.jar
```

### 入口访问（是否启用zuul)
如果启用了zuul-server, 则访问入口为（统一API网关）：
```
http://localhost:2008/gateway-service/user/1
```

如果没有启用zuul-server，则访问入口为（gateway入口)：
```
http://localhost:2000/user/1
```

### Samples
```
GET request: 
http://localhost:2000/order/get/15

POST request: 
http://localhost:2000/order/add

body:
{
    "consignee_id":1,
    "order_item_list":[
        {
            "item_id":1,
            "number":1
        },
        {
            "item_id":2,
            "number":2
        }
    ]
}

```

# License
The project is licensed under the BSD license.

# 项目地址
[https://github.com/linkenpeng/springboot-springcloud](https://github.com/linkenpeng/springboot-springcloud)

欢迎star，欢迎fork，欢迎合作

### 官方微信公众号: 互联网技术的秘密 （intecsec）
![公众号](http://www.intecsec.com/wp-content/uploads/2020/06/intecsec_wechat.jpg)
### [官方网站: www.intecsec.com](http://www.intecsec.com)
### 个人微信号：sindoc
欢迎交流~
