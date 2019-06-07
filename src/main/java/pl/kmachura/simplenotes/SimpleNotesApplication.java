package pl.kmachura.simplenotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SimpleNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleNotesApplication.class, args);
	}

}
