package ru.nntu.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpecialtyController {
    private SpecialtyService service;

    @Autowired
    public SpecialtyController(SpecialtyService service){
        this.service = service;
    }

    @GetMapping("/specialty")
    public String showAllSpecialties(Model model) {
        model.addAttribute("data", service.getAllSpecialties());
        return "specialty";
    }

    @GetMapping("/specialty_add")
    public String addSpecialty(Model model){
        model.addAttribute("specialty", new Specialty());
        return "specialty_add";
    }

    @PostMapping("/specialty_add")
    public String saveSpecialty(@ModelAttribute("specialty") Specialty specialty){
        service.saveSpecialty(specialty);
        return "specialty_add";
    }
}
