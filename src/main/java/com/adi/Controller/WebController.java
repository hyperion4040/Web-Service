package com.adi.Controller;

import com.adi.Model.Book;
import com.adi.Model.Book1;
import com.adi.Repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by hyperion on 09.03.17.
 * Web Controller to validation
 */
@Controller
public class WebController extends WebMvcConfigurerAdapter {


    private static final Logger logger = LoggerFactory
            .getLogger(WebController.class);

    private final BookRepository bookRepository;

    @Autowired
    public WebController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(Book1 book1) {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid Book1 book1, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }
    @GetMapping("/addBook")
    public String getBook(Book book){return "Start";}

    @ModelAttribute("addBook")
    public Book createNewBook(){
        return new Book();

    }

    @PostMapping("/addBook")
    public String addBook(@Valid Book book, BindingResult bindingResult, Model model){


        if (bindingResult.hasErrors())
        {
            logger.info("Errors");
            return "Start";
        }
        else
        {

            logger.info("Book added corect");
            model.addAttribute("addBook",book);

            bookRepository.save(book);


            return "result";
        }

    }

    @GetMapping("/get-by-email")
    @ResponseBody
    public String getByEmail(String author) {
        String bookId;
        try {
            Book book = bookRepository.findByAuthor(author);
            bookId = String.valueOf(book.getId());
        }
        catch (Exception ex) {
            return "Book not found";
        }
        return "The book id is: " + bookId ;
    }



}
