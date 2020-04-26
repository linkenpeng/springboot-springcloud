# springboot-springcloud
> 一个基于springboot、springcloud的项目，主要是用来快速搭建电商项目的微服务骨架

说明：所有的功能都没有做参数强校验，也不考虑各种异常情况，在入参完整的情况下能够跑通流程

简单的功能：

- springcloud 服务注册，服务发现
- 分为商品微服务，用户微服务，活动微服务，交易微服务
- 统一的的gateway，包括签名，统一输出，统一异常

### 各个服务的端口
```
service-discover: 8260
user-service: 2100
item-service: 2200
order-service: 2300
gateway-service: 2000
```