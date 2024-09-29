package ua.lis.mvc4.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lis.mvc4.dao.ApparatusDAO;

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

    @GetMapping("/edit")
    public String edit(Model model){
        return "/apparatus/edit";
    }
}
