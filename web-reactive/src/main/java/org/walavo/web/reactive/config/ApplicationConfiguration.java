package org.walavo.web.reactive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.walavo.web.reactive.model.repository.ProductRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = ProductRepository.class)
public class ApplicationConfiguration {
}
