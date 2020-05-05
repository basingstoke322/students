package ru.nntu.students.Benefit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
