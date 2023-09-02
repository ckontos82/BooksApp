package gr.aueb.cf.booksappfinal.service;

import gr.aueb.cf.booksappfinal.dto.BookDTO;
import gr.aueb.cf.booksappfinal.entities.Book;

import java.util.List;

public interface BookService {
    List<BookDTO> findAll();
    BookDTO findById(Long id);
    List<BookDTO> findByTitleContaining(String name);

    void save(BookDTO bookDTO);
    void deleteById(Long id);
    void updateBook(BookDTO bookDTO);

}
