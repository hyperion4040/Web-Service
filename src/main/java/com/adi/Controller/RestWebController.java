package com.adi.Controller;

import com.adi.Model.Book;
import com.adi.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;


/**
 * Rest controller to pass data
 * Created by hyperion on 31.03.17.
 */
@RestController
@RequestMapping("/library")
public class RestWebController extends WebMvcConfigurerAdapter {


    private final BookRepository bookRepository;

    @Autowired
    public RestWebController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

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
