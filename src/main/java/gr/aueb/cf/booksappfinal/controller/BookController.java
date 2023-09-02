package gr.aueb.cf.booksappfinal.controller;

import gr.aueb.cf.booksappfinal.entities.Book;
import gr.aueb.cf.booksappfinal.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String listBooks(Model model) {
        List<Book> books = bookService.findAll();

        model.addAttribute("books", books);
        return "books/list-books";
    }

    @GetMapping("/search_by_title")
    public String search() {
       return "books/search-by-title";
    }

    @PostMapping("/search_by_title")
    public String searchBooks(@RequestParam("title") String title, Model model) {
        List<Book> books = bookService.findByTitleContaining(title);
        model.addAttribute("books", books);
        return "books/searchResults";
    }

    @GetMapping("/addBook")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);

        return "books/books-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);

        return "redirect:/books/list";
    }

    @GetMapping("updateForm")
    public String updateForm(@RequestParam("bookId") Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);

        return "books/update-form";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);

        return "redirect:/books/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") Long id) {
        bookService.deleteById(id);

        return "redirect:/books/list";
    }

    @GetMapping("/error")
    public String error() {
        return "redirect:/books/list";
    }

}
