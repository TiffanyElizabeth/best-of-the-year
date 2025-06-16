package org.exercises.java.spring.best_of_the_year.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String bestYear(Model model) {
        model.addAttribute("name", "java");
        return "home";
    }

}
