package gr.aueb.cf.booksappfinal.controller.book_controller;

import gr.aueb.cf.booksappfinal.dto.BookDTO;
import gr.aueb.cf.booksappfinal.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class InsertBookController {
    private final BookService bookService;

    public InsertBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/addBook")
    public String addBook(Model model) {
        BookDTO bookDTO = new BookDTO();
        model.addAttribute("book", bookDTO);
        return "books/books-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") BookDTO bookDTO) {
        bookService.save(bookDTO);
        return "redirect:/books/list";
    }
}
