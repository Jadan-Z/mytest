package com.jadan.onlinebooking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.jadan.onlinebooking.*.mapper"})
public class OnlinebookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinebookingApplication.class, args);
    }
}
