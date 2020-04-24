package ru.nntu.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Type_educationController {
    private Type_educationService service;

    @Autowired
    public Type_educationController(Type_educationService service){
        this.service = service;
    }

    @GetMapping("/type_education")
    public String showAllTypesEducation(Model model) {
        model.addAttribute("data", service.getAllTypesEducation());
        return "type_education";
    }

//    @GetMapping("/specialty_add")
//    public String addSpecialty(Model model){
//        model.addAttribute("specialty", new Specialty());
//        return "specialty_add";
//    }
//
//    @PostMapping("/specialty_add")
//    public String saveSpecialty(@ModelAttribute("specialty") Specialty specialty){
//        service.saveSpecialty(specialty);
//        return "specialty_add";
//    }
}
