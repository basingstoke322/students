package ru.nntu.students.Benefit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nntu.students.Entrant.Entrant;
import ru.nntu.students.Specialty.SpecialtyService;
import ru.nntu.students.Type_benefit.Type_benefitService;
import ru.nntu.students.Type_education.Type_educationService;
import ru.nntu.students.blank.BlankService;

@Controller
public class BenefitController {
    private BenefitService benefitService;
    private Type_benefitService tbenefitService;
    private Type_educationService teducationService;

    @Autowired
    public BenefitController(BenefitService benefitService,
                             Type_benefitService tbenefitService, Type_educationService teducationService){
        this.benefitService = benefitService;
        this.tbenefitService = tbenefitService;
        this.teducationService = teducationService;
    }

    @GetMapping("/benefit")
    public String showAllBenefits(Model model) {
        model.addAttribute("data", benefitService.getAllBenefits());
        return "benefit";
    }

    @GetMapping("/benefit_add")
    public String addBenefit(Model model){
        model.addAttribute("benefit", new Benefit());
        model.addAttribute("allTBenefits", tbenefitService.getAllTypesBenefit());
        model.addAttribute("allTEducation", teducationService.getAllTypeEducation());
        return "benefit_add";
    }

    @PostMapping("/benefit")
    public String saveBenefit(@ModelAttribute("benefit") Benefit benefit){
        benefitService.saveBenefit(benefit);
        return "redirect:/benefit";
    }

    @GetMapping("/benefit_edit")
    public String editBenefit(@RequestParam("id") int id, Model model){
        model.addAttribute("benefit", benefitService.findById(id));
        model.addAttribute("allTBenefits", tbenefitService.getAllTypesBenefit());
        model.addAttribute("allTEducation", teducationService.getAllTypeEducation());
        return "benefit_add";
    }

    @GetMapping("/benefit_delete")
    public String safeDelete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", benefitService.safeDelete(id));
        return "benefit";
    }
}
