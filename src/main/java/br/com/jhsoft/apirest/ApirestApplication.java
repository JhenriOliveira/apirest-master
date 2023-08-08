package br.com.jhsoft.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.jhsoft.entity"})
@ComponentScan(basePackages = {"br.com.jhsoft.*"})
@EnableJpaRepositories(basePackages = {"br.com.jhsoft.repository"})
public class ApirestApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

}
