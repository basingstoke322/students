package ru.nntu.students.Entrant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.nntu.students.Benefit.BenefitService;
import ru.nntu.students.Specialty.SpecialtyService;
import ru.nntu.students.blank.BlankService;

@Controller
public class EntrantController {
    private EntrantService entrantService;
    private BlankService blankService;
    private SpecialtyService specialtyService;
    private BenefitService benefitService;

    @Autowired
    public EntrantController(EntrantService entrantService, BlankService blankService, SpecialtyService specialtyService,
                             BenefitService benefitService){
        this.entrantService = entrantService;
        this.blankService = blankService;
        this.benefitService = benefitService;
        this.specialtyService = specialtyService;
    }

    @GetMapping("/entrant")
    public String showAllEntrants(Model model) {
        model.addAttribute("data", entrantService.getAllEntrants());
        return "entrant";
    }

    @GetMapping("/blank_cond")
    public String blankCondition(Model model) {
        model.addAttribute("allBlanks", blankService.getAllBlank());
        return "blank_cond";
    }

    @GetMapping("/entrant_add")
    public String addEntrant(Model model){
        model.addAttribute("entrant", new Entrant());
        model.addAttribute("allBenefits", benefitService.getAllBenefits());
        model.addAttribute("allSpecialties", specialtyService.getAllSpecialties());
        model.addAttribute("allBlanks", blankService.getAllBlank());
        return "entrant_add";
    }

    @PostMapping("/entrant")
    public String saveEntrant(@ModelAttribute("entrant") Entrant entrant, Model model){
        entrantService.saveEntrant(entrant);
        return "redirect:/entrant";
    }

    @GetMapping("/entrant_edit")
    public String editEntrant(@RequestParam("id") int id, Model model){
        try {
            model.addAttribute("entrant", entrantService.findById(id));
            model.addAttribute("allBenefits", benefitService.getAllBenefits());
            model.addAttribute("allSpecialties", specialtyService.getAllSpecialties());
            model.addAttribute("allBlanks", blankService.getAllBlank());
        }
        catch (Exception e){
            return "redirect:/error";
        }

        return "entrant_add";
    }

    @GetMapping("/entrant_delete")
    public String safeDelete(@RequestParam("id") int id, Model model){
        try {
            model.addAttribute("delete", entrantService.safeDelete(id));
        }
        catch (Exception e){
            return "redirect:/error";
        }
        return "entrant";
    }
}
