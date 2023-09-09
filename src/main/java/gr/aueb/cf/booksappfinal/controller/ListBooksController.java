package gr.aueb.cf.booksappfinal.controller;

import gr.aueb.cf.booksappfinal.dto.BookDTO;
import gr.aueb.cf.booksappfinal.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class ListBooksController {
    private final BookService bookService;

    public ListBooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String listBooks(Model model) {
        List<BookDTO> bookDTOs = bookService.findAll();
        model.addAttribute("books", bookDTOs);
        return "books/list-books";
    }
}
