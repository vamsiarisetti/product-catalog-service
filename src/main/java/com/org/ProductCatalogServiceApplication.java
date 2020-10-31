package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@EnableJpaRepositories("com.org.repository")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ProductCatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogServiceApplication.class, args);
    }
}
