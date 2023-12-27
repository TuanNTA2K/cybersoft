package com.cybersoft.crm04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String showIndexPage() {
        return "index"; // Assuming "index" is the name of your HTML view file (index.html)
    }
}
