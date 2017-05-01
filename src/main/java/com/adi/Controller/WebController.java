package com.adi.Controller;

import com.adi.Model.Book;
import com.adi.Repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by hyperion on 09.03.17.
 * Web Controller to validation
 */
@Controller
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
        model.addAttribute("book",new Book());
        return "addBook";
    }

    @GetMapping("/book/result")
    public String showAddedBook(Model model){
        model.addAttribute("book", bookRepository.findAll());
        return "result";
    }


    @PostMapping("/book/add")
    public String addBookSubmit(@Valid  Book book, BindingResult bindingResult, Model model){


        if (bindingResult.hasErrors())
        {
            logger.info("Errors");
            return "addBook";
        }
        else
        {

            model.addAttribute("author", book.getAuthor());
            model.addAttribute("title",book.getTitle());
//            model.addAttribute("readDate",book.getReadDate());
            book.setId(null);
            bookRepository.save(book);
            logger.info( "We now have " + bookRepository.count() + " books");
            return "result";
        }

    }





}
