package by.tms.lesson5741onl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GreetingController {

    @GetMapping
    public String greeting() {
        return "greeting";
    }

    @PostMapping
    public String greeting(@RequestParam(defaultValue = "World") String name, Model model) {
        String message = "Hello %s!".formatted(name);
        model.addAttribute("message", message);
        return "greeting";
    }
}
