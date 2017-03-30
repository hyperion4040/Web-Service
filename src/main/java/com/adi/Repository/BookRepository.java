package com.adi.Repository;

import com.adi.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * hmm
 * Created by hyperion on 08.03.17.
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

        Book findByAuthor(String author);

        List<Book> findByTitleIgnoreCaseContaining(String name);
}
