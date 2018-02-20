package ua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.repository.BookRepository;

@SpringBootApplication
public class SpringBootLibraryWebAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootLibraryWebAppApplication.class, args);
		System.out.println(run.getBean(BookRepository.class).findAll());
	}
}
