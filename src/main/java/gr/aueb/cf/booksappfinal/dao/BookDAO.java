package gr.aueb.cf.booksappfinal.dao;

import gr.aueb.cf.booksappfinal.entities.Book;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();
    Book findById(Long id);
    List<Book> findByTitleContaining(String title);
    void save(Book book);
    void deleteById(Long id);
    void update(Book book);
}
