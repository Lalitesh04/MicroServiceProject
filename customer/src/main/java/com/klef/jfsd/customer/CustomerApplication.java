package com.klef.jfsd.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication(scanBasePackages = {
        "com.klef.jfsd.customer",
        "com.klef.jfsd.mq",
})
@EnableFeignClients(basePackages = "com.klef.jfsd.clients")
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class , args);
    }
}
