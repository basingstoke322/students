package ru.nntu.students;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String show_error(Model model) {
        if(model.getAttribute("status").equals("")){
            return "error404";
        }
        return "error";
    }
}
