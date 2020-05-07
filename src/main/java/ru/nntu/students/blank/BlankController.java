package ru.nntu.students.blank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlankController {
    private BlankService service;

    @Autowired
    public BlankController(BlankService service) {
        this.service = service;
    }

    @GetMapping("/blank")
    public String showAllBlank(Model model) {
        model.addAttribute("data", service.getAllBlank());
        return "blank";
    }

    @GetMapping("/blankAddGet")
    public String addBlank(Model model) {
        model.addAttribute("Blank", new Blank());
        return "blankAdd";
    }

//    @PostMapping("/blankAd")
//    @ResponseBody
//    public String saveBlank(@ModelAttribute("Blank") Blank blank, Model model) {
//        service.saveBlank(blank);
//        System.out.println(blank.getIdBlank());
//        return ""+blank.getIdBlank();
//    }

    @RequestMapping(value = "/blankAddPost")
    @ResponseBody
    public String saveBlank(@ModelAttribute("Blank") Blank blank) {
        service.saveBlank(blank);
        return String.valueOf(blank.getIdBlank());
    }


    @GetMapping("/BlankEdit")
    public String editBlank(@RequestParam("id") int id, Model model) {
        model.addAttribute("Blank", service.findById(id));
        return "blankAdd";
    }

    @GetMapping("/blank_delete")
    public String safeDelete(@RequestParam("id") int id, Model model){
        model.addAttribute("delete", service.safeDelete(id));
        return "blank";
    }
}
