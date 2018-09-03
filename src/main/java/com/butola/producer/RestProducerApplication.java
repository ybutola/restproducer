package com.butola.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class RestProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestProducerApplication.class, args);
    }
}
