package ru.nntu.students;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String LoginForm(Model model) {
        model.addAttribute("LoginData", new LoginData());
        model.addAttribute("title", "Log in");
        return "login";
    }

    @PostMapping("/login")
    public String LoginSubmit(@ModelAttribute LoginData data, Model model) {
        String result = "login_failed";
        model.addAttribute("title", "Log in");
        if (data.getLogin().equals("admin") && data.getPassword().equals("123456")) {
            result = "index";
        }
        return result;
    }
}