package gr.aueb.cf.booksappfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLogin() {
        return "/books/login";
    }
}
