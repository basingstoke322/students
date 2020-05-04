package ru.nntu.students.Specialty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/specialty")
    public String saveSpecialty(@ModelAttribute("specialty") Specialty specialty, Model model){
        service.saveSpecialty(specialty);
        return "redirect:/specialty";
    }

    @GetMapping("/specialty_edit")
    public String editSpecialty(@RequestParam("id") int id, Model model){
        model.addAttribute("specialty", service.findById(id));
        return "specialty_add";
    }

    @GetMapping("/specialty_delete")
    public String safeDelete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", service.safeDelete(id));
        return "specialty";
    }
}
