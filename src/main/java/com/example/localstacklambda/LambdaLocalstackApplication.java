package com.example.localstacklambda;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication
public class LambdaLocalstackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LambdaLocalstackApplication.class, args);
    }

    @Bean(name = "event-printer")
    public Function<SQSEvent, String> sqsEventConsumer() {
        return value -> {
            System.out.println("I'm here!!!");

            value.getRecords().forEach(System.out::println);

            return "Success!";
        };
    }
}
