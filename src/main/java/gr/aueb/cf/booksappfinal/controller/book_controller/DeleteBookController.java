package gr.aueb.cf.booksappfinal.controller.book_controller;

import gr.aueb.cf.booksappfinal.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class DeleteBookController {
    private final BookService bookService;

    public DeleteBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("bookId") Long id) {
        bookService.deleteById(id);
        return "redirect:/books/list";
    }
}
