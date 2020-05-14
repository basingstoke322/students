package ru.nntu.students.Type_education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nntu.students.Specialty.Specialty;
import ru.nntu.students.Specialty.SpecialtyService;

@Controller
public class Type_educationController {
    private Type_educationService service;

    @Autowired
    public Type_educationController(Type_educationService service){
        this.service = service;
    }

    @GetMapping("/type_education")
    public String showAllTypesEducation(Model model) {
        model.addAttribute("data", service.getAllTypeEducation());
        return "type_education";
    }

    @GetMapping("/type_education_add")
    public String addTypeEducation(Model model){
        model.addAttribute("type_education", new Type_education());
        return "type_education_add";
    }

    @PostMapping("/type_education")
    public String saveTypeEducation(@ModelAttribute("type_education") Type_education type_education, Model model){
        service.saveTypeEducation(type_education);
        return "redirect:/type_education";
    }

    @GetMapping("/type_education_edit")
    public String editTypeEducation(@RequestParam("id") int id, Model model){
        try{
            model.addAttribute("type_education", service.findById(id));
        }
        catch (Exception e){
            return "redirect:/error";
        }

        return "type_education_add";
    }

    @GetMapping("/type_education_delete")
    public String safeDelete(@RequestParam("id") int id, Model model){
        try {
            model.addAttribute("delete", service.safeDelete(id));
        }
        catch (Exception e){
            return "redirect:/error";
        }
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
