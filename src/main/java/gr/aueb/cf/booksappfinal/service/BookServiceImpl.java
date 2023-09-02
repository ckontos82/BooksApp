package gr.aueb.cf.booksappfinal.service;

import gr.aueb.cf.booksappfinal.dao.BookDAO;
import gr.aueb.cf.booksappfinal.dto.BookDTO;
import gr.aueb.cf.booksappfinal.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<BookDTO> findAll() {
        return bookDAO.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO findById(Long id) {
        Book book = bookDAO.findById(id);
        if (book != null) {
            return convertToDTO(book);
        } else {
            throw new RuntimeException("Book not found.");
        }
    }

    @Override
    public List<BookDTO> findByTitleContaining(String title) {
        return bookDAO.findByTitleContaining(title).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void save(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        bookDAO.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookDAO.deleteById(id);
    }

    @Override
    public void updateBook(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        bookDAO.update(book);
    }

    private BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setPrice(book.getPrice());
        return bookDTO;
    }

    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setPrice(bookDTO.getPrice());
        return book;
    }
}
