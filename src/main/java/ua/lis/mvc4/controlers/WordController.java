/* Контроллер обозначенный меткой для удаления*/

package ua.lis.mvc4.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lis.mvc4.dao.WordDAO;

@Controller
@RequestMapping("/word")
public class WordController {

    public WordDAO wordDAO;

    @Autowired
    public WordController(WordDAO wordDAO) {
        this.wordDAO = wordDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("randomSentence", wordDAO.getSentence());
        return "/word/index";
    }
}
