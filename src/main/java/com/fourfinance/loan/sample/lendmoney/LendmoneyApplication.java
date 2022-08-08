package com.fourfinance.loan.sample.lendmoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.fourfinance.loan.sample.lendmoney")
@EntityScan("com.fourfinance.loan.sample.lendmoney")
@EnableJpaRepositories("com.fourfinance.loan.sample.lendmoney")
public class LendmoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LendmoneyApplication.class, args);
	}

}
