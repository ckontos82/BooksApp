package gr.aueb.cf.booksappfinal.controller;

import gr.aueb.cf.booksappfinal.dto.BookDTO;
import gr.aueb.cf.booksappfinal.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class UpdateBookController {
    private final BookService bookService;

    public UpdateBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("updateForm")
    public String updateForm(@RequestParam("bookId") Long id, Model model) {
        BookDTO bookDTO = bookService.findById(id);
        model.addAttribute("book", bookDTO);
        return "books/update-form";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") BookDTO bookDTO) {
        bookService.updateBook(bookDTO);
        return "redirect:/books/list";
    }
}
