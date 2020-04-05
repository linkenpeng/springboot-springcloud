#!/usr/bin/env bash

mvn clean install
java -jar service-discover/target/service-discover-1.0-SNAPSHOT.jar
java -jar -Dspring.profiles.active=sdpeer1 service-discover/target/service-discover-1.0-SNAPSHOT.jar
java -jar -Dspring.profiles.active=sdpeer2 service-discover/target/service-discover-1.0-SNAPSHOT.jar
java -jar -Dspring.profiles.active=sdpeer3 service-discover/target/service-discover-1.0-SNAPSHOT.jar


java -jar mall-user/target/mall-user-1.0-SNAPSHOT.jar
java -jar mall-item/target/mall-item-1.0-SNAPSHOT.jar
java -jar mall-order/target/mall-order-1.0-SNAPSHOT.jar
java -jar mall-gateway/target/mall-gateway-1.0-SNAPSHOT.jar