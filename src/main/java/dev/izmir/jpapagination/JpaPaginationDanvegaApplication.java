package dev.izmir.jpapagination;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class JpaPaginationDanvegaApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(JpaPaginationDanvegaApplication.class);
		String port = System.getenv("PORT");
		app.setDefaultProperties(Collections.singletonMap("server.port", port == null ? "8082" : port));
		app.run(args);

	}


	@Bean
	public Faker faker() {
		return new Faker();
	}
}
