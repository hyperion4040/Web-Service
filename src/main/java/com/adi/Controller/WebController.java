package com.adi.Controller;

import com.adi.Model.Book;
import com.adi.Repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @GetMapping("/book/add")
    public String addBookForm(Model model){
//        model.addAttribute("addBook",new Book());
        return "addBook";
    }


    @PostMapping("/book/add")
    public String addBookSubmit(@Valid  @ModelAttribute Book book, BindingResult bindingResult, Model model){


        if (bindingResult.hasErrors())
        {
            logger.info("Errors");
            return "addBook";
        }
        else
        {
            model.addAttribute("author", book.getAuthor());
            model.addAttribute("title",book.getTitle());
            book.setId(null);
            bookRepository.save(book);
            logger.info( "We now have " + bookRepository.count() + " books");
            return "result";
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
