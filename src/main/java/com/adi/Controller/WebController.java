package com.adi.Controller;

import com.adi.Model.Book;
import com.adi.Repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hyperion on 09.03.17.
 * Web Controller to validation
 */
@RestController
@RequestMapping("/library")
public class WebController extends WebMvcConfigurerAdapter {


    private static final Logger logger = LoggerFactory
            .getLogger(WebController.class);

    private final BookRepository bookRepository;

    @Autowired
    public WebController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @PutMapping("/Book/add")
    public String addBook(@Valid @RequestBody Book book, BindingResult bindingResult){


        if (bindingResult.hasErrors())
        {
            logger.info("Errors");
            return "Start";
        }
        else
        {
            book.setId(null);
            bookRepository.save(book);
            return "We now have " + bookRepository.count() + " books";
        }

    }



    @RequestMapping("/book/find/{name}")
    public List<Book> find(@PathVariable String name) {
        return bookRepository.findByTitleIgnoreCaseContaining(name);
    }
    @RequestMapping("/book/findall")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}
