package ru.nntu.students.blank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlankController {
    private BlankService service;

    @Autowired
    public BlankController(BlankService service){
        this.service = service;
    }

    @GetMapping("/blank")
    public String showAllBlank(Model model) {
        model.addAttribute("data", service.getAllBlank());
        return "blank";
    }

    @GetMapping("/blankAdd")
    public String addBlank(Model model){
        model.addAttribute("Blank", new Blank());
        return "blankAdd";
    }

    @PostMapping("/blankAdd")
    public String saveBlank(@ModelAttribute("Blank") Blank blank, Model model){
        service.saveBlank(blank);
        return "redirect:/blank";
    }

    @GetMapping("/BlankEdit")
    public String editBlank(@RequestParam("id") int id, Model model){
        model.addAttribute("Blank", service.findById(id));
        return "BlankEdit";
    }
}
