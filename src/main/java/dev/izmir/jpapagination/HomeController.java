package dev.izmir.jpapagination;


import dev.izmir.jpapagination.model.Person;
import dev.izmir.jpapagination.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final PersonRepository repository;

    public HomeController(PersonRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/results")
    public String showResults(Model model) {
        model.addAttribute("name", "Too Easy");
        PageRequest page = PageRequest.of(1,10);
        Page<Person> youhou = repository.findAll((page));
        model.addAttribute("people", youhou.getContent());
        return "home";
    }


}
