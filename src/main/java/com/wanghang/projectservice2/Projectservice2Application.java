package com.wanghang.projectservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.wanghang.*")
@ComponentScan("com.wanghang.*")
public class Projectservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(Projectservice2Application.class, args);
    }

}
