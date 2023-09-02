package gr.aueb.cf.booksappfinal.service;

import gr.aueb.cf.booksappfinal.dao.BookDAO;
import gr.aueb.cf.booksappfinal.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book findById(Long id) {
        Book result = bookDAO.findById(id);
        Book book;

        if (result != null) {
            book = result;
        } else {
            throw new RuntimeException("Book not found.");
        }

        return book;
    }

    @Override
    public List<Book> findByTitleContaining(String title) {
        return bookDAO.findByTitleContaining(title);
    }

    @Override
    public void save(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookDAO.deleteById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.update(book);
    }
}
