package com.adi.Repository;

import com.adi.Model.Book;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * hmm
 * Created by hyperion on 08.03.17.
 */
@Transactional
public interface BookRepository extends CrudRepository<Book,Long>{

        Book findByAuthor(String author);

}
