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

        public CommandLineRunner demo (BookRepository bookRepository){
        return (String... args) -> {
          bookRepository.save( new Book("Lord of the rings", "Tolkien"));
            bookRepository.save(new Book("Hobbit", "Tolkien"));
            bookRepository.save(new Book("XXX", "YYY"));





            // fetch all customers
            log.info("Books found with findAll():");
            log.info("-------------------------------");
            for (Book book : bookRepository.findAll()) {
                log.info(book.toString());
            }
            log.info("");


        };
    }

}
