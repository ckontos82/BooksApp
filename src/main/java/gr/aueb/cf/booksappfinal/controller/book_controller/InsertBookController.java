package gr.aueb.cf.booksappfinal.controller.book_controller;

import gr.aueb.cf.booksappfinal.dto.BookDTO;
import gr.aueb.cf.booksappfinal.service.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String saveBook(@Valid @ModelAttribute("book") BookDTO bookDTO, BindingResult result, Model model) {
        if (result.hasFieldErrors("price")) {
            result.rejectValue("price", null, "Invalid price entered. Please enter a valid number.");
        }

        if (result.hasErrors()) {
            return "books/books-form";
        }

        bookService.save(bookDTO);
        return "redirect:/books/list";
    }
}
