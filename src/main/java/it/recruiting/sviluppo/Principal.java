package it.recruiting.sviluppo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("it.recruiting.sviluppo.repos")
public class Principal {

	public static void main(String[] args) {
		SpringApplication.run(Principal.class, args);
	}

}
