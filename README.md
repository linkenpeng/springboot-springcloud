# springboot-springcloud
> 一个基于springboot、springcloud的项目，主要是用来快速搭建电商项目的微服务骨架

说明：所有的功能都没有做参数强校验，也不考虑各种异常情况，在入参完整的情况下能够跑通流程

简单的功能：

- springcloud 服务注册，服务发现
- 分为商品微服务，用户微服务，活动微服务，交易微服务
- 统一的的gateway，包括签名，统一输出，统一异常

### Require Components
- MySQL5.6+

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


### 入口访问（是否启用zuul)
如果启用了zuul-server, 则访问入口为（统一API网关）：
```
http://localhost:2008/gateway-service/user/1
```

如果没有启用zuul-server，则访问入口为（gateway入口)：
```
http://localhost:2000/user/1
```

### 微信公众号: 互联网技术的秘密 （intecsec）
![公众号](http://www.intecsec.com/wp-content/uploads/2020/06/intecsec_wechat.jpg)
### [官方网站: www.intecsec.com](http://www.intecsec.com)
### 个人微信号：sindoc
欢迎交流~
