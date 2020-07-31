package com.bytesw.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //se conecta al server
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
