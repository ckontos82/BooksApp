package gr.aueb.cf.booksappfinal.controller.book_controller;

import gr.aueb.cf.booksappfinal.dto.BookDTO;
import gr.aueb.cf.booksappfinal.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
public class FindBookController {
    private final BookService bookService;

    public FindBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search_by_title")
    public String search() {
        return "books/search-by-title";
    }

    @PostMapping("/search_by_title")
    public String searchBooks(@RequestParam("title") String title, Model model) {
        List<BookDTO> bookDTOs = bookService.findByTitleContaining(title);
        model.addAttribute("books", bookDTOs);
        return "books/searchResults";
    }
}
