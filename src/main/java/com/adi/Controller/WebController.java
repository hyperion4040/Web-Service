package com.adi.Controller;

import com.adi.Model.Book;
import com.adi.Repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hyperion on 09.03.17.
 * Web Controller to validation
 */
@RestController
public class WebController { //extends WebMvcConfigurerAdapter {


    private static final Logger logger = LoggerFactory
            .getLogger(WebController.class);
    @Autowired
     BookRepository bookRepository;

//    @Autowired
//    public WebController(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/results").setViewName("results");
//    }

//    @GetMapping("/")
//    public String showForm(Book1 book1) {
//        return "form";
//    }
//
//    @PostMapping("/")
//    public String checkPersonInfo(@Valid Book1 book1, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "form";
//        }
//
//        return "redirect:/results";
//    }
    @GetMapping("/Book/get")
    public String getBook(Book book){return "Start";}

    @ModelAttribute("addBook")
    public Book createNewBook(){
        return new Book();

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

    @RequestMapping("/book/find/{name}")
    public List<Book> find(@PathVariable String name) {
        return bookRepository.findByTitleIgnoreCaseContaining(name);
    }
    @RequestMapping("/book/findall")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}
