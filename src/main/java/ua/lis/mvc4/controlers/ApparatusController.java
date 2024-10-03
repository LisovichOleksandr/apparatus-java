package ua.lis.mvc4.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lis.mvc4.apparatus.FormVerb;
import ua.lis.mvc4.dao.ApparatusDAO;

import java.text.Normalizer;

@Controller
@RequestMapping("/apparatus")
public class ApparatusController {

    public ApparatusDAO apparatusDAO;

    @Autowired
    public ApparatusController(ApparatusDAO apparatusDAO) {
        this.apparatusDAO = apparatusDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("sentence", apparatusDAO.getSentence());
        return "/apparatus/index";
    }

    @GetMapping("/show")
    public String show(Model model){
        model.addAttribute("show", apparatusDAO.getTenVerb());
        return "/apparatus/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("verbEdit", apparatusDAO.getVerb(id));
        return "/apparatus/edit";
    }

    @GetMapping("/new")
    public String newWordForm(Model model){
        model.addAttribute("verb", new FormVerb());
        return "/apparatus/new";
    }

    @PostMapping("/new")
    public String createWord(@ModelAttribute("newVerb") FormVerb formVerb){
        apparatusDAO.saveVerb(formVerb);
        return "redirect:/apparatus";
    }

    @PatchMapping("/verb/{id}")
    public String updateVerb(@ModelAttribute("verb") FormVerb formVerb, @PathVariable("id") int id){
        apparatusDAO.updateVerb(formVerb, id);
        return "redirect:/apparatus/show";
    }

}
