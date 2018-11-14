package com.kiktan.test

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ImportResource


@SpringBootApplication
@ImportResource("classpath:camel-context.xml")
class TestApplication {

	static void main(String[] args) {
		SpringApplication.run TestApplication, args
	}
}
