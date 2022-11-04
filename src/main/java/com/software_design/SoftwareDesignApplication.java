package com.software_design;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SoftwareDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftwareDesignApplication.class, args);
    }

}
