package ru.nntu.students.Type_benefit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nntu.students.Specialty.Specialty;

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
    @GetMapping("/type_benefit_add")
    public String addTypeBenefit(Model model){
       model.addAttribute("type_benefit", new Type_benefit());
       return "type_benefit_add";
    }

    @PostMapping("/type_benefit")
    public String saveTypeBenefit(@ModelAttribute("type_benefit") Type_benefit type_benefit, Model model){
        service.saveTypeBenefit(type_benefit);
        return "redirect:/type_benefit";
    }

    @GetMapping("/type_benefit_edit")
    public String editTypeBenefit(@RequestParam("id") int id, Model model){
        model.addAttribute("type_benefit", service.findById(id));
        return "type_benefit_add";
    }

    @GetMapping("/type_benefit_delete")
    public String safeDelete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", service.safeDelete(id));
        return "type_benefit";
    }
}
