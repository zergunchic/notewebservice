package ru.yellow.notewebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ru.yellow.notewebservice"})
@EntityScan("ru.yellow.entitys")
@EnableJpaRepositories("ru.yellow.repos")
public class NotewebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotewebserviceApplication.class, args);
	}

}
