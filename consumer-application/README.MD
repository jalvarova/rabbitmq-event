# Rabbit MQ Consumer Steamer

## Init Configuration Environment

### Run Mongo local

```docker
cd docker
docker-compode up -d
### Maven Build

```

### Build Package Project

```mvn
mvn clean package spring-boot:repackage
```

### Sprint Boot Stared

```mvn
mvn spring-boot:run
```

```java
package org.walavo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
```
### Sprint Boot application.yml

```yaml
spring:
  cloud:
    stream:
      bindings:
        product:
          destination: local.product-exchange
          group: create_product_q
          consumer:
            max-attempts: 3
            acknowledge-mode: AUTO
            #dlx/dlq setup
            #auto-bind-dlq: true
            #dlq-ttl: 5000
            #dlq-dead-letter-exchange:
      #        output:
      #          destination: create_product_q
      #          binder: local.example.product.create
---
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: user
    password: password
---
management:
  endpoints:
    web:
      base-path: /
      path-mapping:
        prometheus: /metrics
      exposure:
        include:
          - health
          - info
          - metrics
          - prometheus
        exclude:
---
spring:
  data:
    mongodb:
      host: localhost
      username: mongo
      password: 12345
```



### Install Mongo Cli

```shell
sudo apt install mongodb-clients -y
```

### Mongo Operation commands


```mongo
mongo --host localhost:27017
show dbs
use product-db
db.products.find({})
```

#References
[Started RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)

[Spring Cloud RabbitMQ](https://cloud.spring.io/spring-cloud-static/spring-cloud-stream-binder-rabbit/2.2.0.M1/spring-cloud-stream-binder-rabbit.html#_rabbitmq_binder_overview)

[Docker Mongo](https://medium.com/faun/managing-mongodb-on-docker-with-docker-compose-26bf8a0bbae3)