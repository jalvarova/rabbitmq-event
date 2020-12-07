# Rabbit MQ Started

## Init Configuration Environment

### Run Docker rabbit local

```docker
docker run -d --hostname local-rabbitmq --name local-rabbitmq -e RABBITMQ_DEFAULT_USER=user -e RABBITMQ_DEFAULT_PASS=password -p 5672:5672 -p 15672:15672 rabbitmq:3-management
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
package org.walavo.web.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebReactiveApplication.class, args);
    }
}
```

