package ua.lis.mvc4.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.lis.mvc4.dao.PersonDAO;
import ua.lis.mvc4.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("")
    public String index(Model model){
        //получим всех людей из DAO, и передадим на представление
        model.addAttribute("people", personDAO.index());
        return "/people/index";
    }
    @GetMapping("/{id}")
    //С помощью PathVariable получаем доступ к "/{id}"
    public String show(@PathVariable("id") int id, Model model){
        //Получим человека по id и передадим на представление
        model.addAttribute("person", personDAO.show(id));
        return "/people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    /* @ModelAttribute("person") Person person -- создает Person person, помещает данные из формы в person*/
    public String create(@ModelAttribute("person") @Valid Person person,  //@Valid - что-бы значения из формы валидировались
                         // BindingResult - должен ити следующим аргументом после аннотации @Valid
                         BindingResult bindingResult){  // єсли условия нарушаются - ошибка, помещается в обьєкт BindingResult
        // Можем проверить есть ли ошибки
        if (bindingResult.hasErrors())
            //После перехода в новую форму, обьект уже будет содержать в себе ошибки, которые мы сможем показать с помощью thymeleaf
            return "people/new";
        personDAO.save(person);
        /* После добавления в базу данных делаем redirect на /people*/
        return "redirect:/people";
    }

    // String for edit people
    @
    GetMapping("/{id}/edit")
    //1-- model, 2--@PathVariable("id") int id -- extract id
    public String edit(Model model, @PathVariable("id") int id){
        //Поместить человека в модель по id
    model.addAttribute("person", personDAO.show(id));
        System.out.println("/{id}/edit");
    return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
            BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "people/edit";
        personDAO.update(id, person);
        System.out.println("@PatchMapping(id)  redirect:/people");
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
