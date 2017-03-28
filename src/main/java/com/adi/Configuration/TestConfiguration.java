package com.adi.Configuration;

import com.adi.Model.Book;
import com.adi.PomApplication;
import com.adi.Repository.BookRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hyperion on 09.03.17.
 * This Configuration file was been created to move configuration bean from PomApplication class
 */
@Configuration
public class TestConfiguration {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PomApplication.class);

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (String... args) -> {
            repository.save(new Book("Lord of the rings", "Tolkien"));
            repository.save(new Book("Hobbit", "Tolkien"));
            repository.save(new Book("XXX", "YYY"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Book customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

//            log.info("Search for concrete author = Tolkien");
//            log.info("......................................");
//            for (Book tolkien : repository.findByAuthor("Tolkien")) {
//                log.info(tolkien.toString());
//            }
        };
    }
}
