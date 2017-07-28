package com.yuksi.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Yuksi on 27.07.2017.
 */

@SpringBootApplication(scanBasePackages={"com.yuksi"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
