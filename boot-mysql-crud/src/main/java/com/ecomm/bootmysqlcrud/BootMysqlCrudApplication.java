package com.ecomm.bootmysqlcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BootMysqlCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMysqlCrudApplication.class, args);
	}

}
