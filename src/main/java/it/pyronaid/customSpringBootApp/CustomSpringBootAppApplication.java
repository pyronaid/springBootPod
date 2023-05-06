package it.pyronaid.customSpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CustomSpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomSpringBootAppApplication.class, args);
	}

}
