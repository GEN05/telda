package com.test.telda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.test.telda.repository")
@ConfigurationProperties(prefix = "spring.datasource")
public class TeldaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeldaApplication.class, args);
    }

}
