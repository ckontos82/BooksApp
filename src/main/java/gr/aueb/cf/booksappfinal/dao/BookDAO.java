package gr.aueb.cf.booksappfinal.dao;

import gr.aueb.cf.booksappfinal.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();
    Book findById(Long id);
    void save(Book book);
    void deleteById(Long id);
    void update(Book book);
}
