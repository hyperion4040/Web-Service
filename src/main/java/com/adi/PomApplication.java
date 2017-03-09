package com.adi;

import com.adi.Model.Book;
import com.adi.Repository.BookRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PomApplication {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(PomApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PomApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository){
		return (String... args) ->{
			repository.save(new Book(1,"Lord of the rings","Tolkien"));
			repository.save(new Book(2,"Hobbit","Tolkien"));
			repository.save(new Book(3, "XXX", "YYY"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Book customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			log.info("Search for concrete author = Tolkien");
			log.info("......................................");
			for (Book tolkien : repository.findByAuthor("Tolkien")){
				log.info(tolkien.toString());
			}
		};
	}


}
