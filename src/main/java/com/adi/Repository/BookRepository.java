package com.adi.Repository;

import com.adi.Model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hyperion on 08.03.17.
 */
public interface BookRepository extends CrudRepository<Book,Long>{

        List<Book> findByAuthor(String author);

}
