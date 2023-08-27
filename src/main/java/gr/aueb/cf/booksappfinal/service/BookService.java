package gr.aueb.cf.booksappfinal.service;

import gr.aueb.cf.booksappfinal.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    void save(Book book);
    void deleteById(Long id);

}
