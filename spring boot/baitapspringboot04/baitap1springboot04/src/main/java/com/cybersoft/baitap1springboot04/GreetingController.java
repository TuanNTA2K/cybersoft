package com.cybersoft.baitap1springboot04;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting() {
        return "greeting";
    }

    @PostMapping("/welcome")
    public String welcome(@RequestParam String userName, Model model) {
        model.addAttribute("userName", userName);
        return "welcome";
    }
}

