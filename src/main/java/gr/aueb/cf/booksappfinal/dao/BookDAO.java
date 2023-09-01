package gr.aueb.cf.booksappfinal.dao;

import gr.aueb.cf.booksappfinal.entities.Book;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface BookDAO extends CrudRepository<Book, Long> {
    List<Book> findAll();

}
