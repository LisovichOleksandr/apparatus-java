package ua.lis.mvc4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {



    @GetMapping("/start")
    public String myStartEndpoint(HttpServletRequest request){  //request -- целый обьект из которого дёргаем getParameter
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello " + name + surname);
        return "start";
    }
    @GetMapping("/recent")  // недавний
    /*required = false делает вводимые в браузере параметры опциональными*/
    public String recentEP(@RequestParam(value = "key", required = false) String key, Model model){ // Получаем только параметр key
        model.addAttribute("message", "Mourinho is " + key);

        //System.out.println("You are " + key);
        return "recent";
    }
    @GetMapping("/finish")
    public String myFinishEndpoint(){
        return "finish";
    }
    @GetMapping("/receive")
    public String myReceiveEndpoint(){
        return "receive";
    }
}

