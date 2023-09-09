package gr.aueb.cf.booksappfinal.controller.book_controller;

import gr.aueb.cf.booksappfinal.dto.BookDTO;
import gr.aueb.cf.booksappfinal.service.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String updateBook(@Valid @ModelAttribute("book") BookDTO bookDTO, BindingResult result) {
        if (result.hasFieldErrors("price")) {
            result.rejectValue("price", "", "Invalid price entered. Please enter a valid number.");
        }

        if (result.hasErrors()) {
            return "books/update-form";
        }

        bookService.updateBook(bookDTO);
        return "redirect:/books/list";
    }
}
