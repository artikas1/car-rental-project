package com.rental.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CarRentalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalApiApplication.class, args);
	}

}
