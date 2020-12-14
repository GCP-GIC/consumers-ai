package com.cts.consumers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumersAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumersAiApplication.class, args);
	}

}
