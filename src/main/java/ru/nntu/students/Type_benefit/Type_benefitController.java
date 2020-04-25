package ru.nntu.students.Type_benefit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Type_benefitController {
    private Type_benefitService service;

    @Autowired
    public Type_benefitController(Type_benefitService service){
        this.service = service;
    }

    @GetMapping("/type_benefit")
    public String showAllTypesBenefit(Model model) {
            model.addAttribute("data", service.getAllTypesBenefit());
        return "type_benefit";
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
