package gr.aueb.cf.booksappfinal.dao;

import gr.aueb.cf.booksappfinal.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDAO extends JpaRepository<Book, Long> {

    List<Book> findAll();

}
