#!/usr/bin/env bash

mvn clean install
java -jar service-discover/target/service-discover-1.0-SNAPSHOT.jar
java -jar mall-user/target/mall-user-1.0-SNAPSHOT.jar
java -jar mall-gateway/target/mall-gateway-1.0-SNAPSHOT.jar