package dev.godraadam.dsassingment;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class DsAssingmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsAssingmentApplication.class, args);
    }
}
