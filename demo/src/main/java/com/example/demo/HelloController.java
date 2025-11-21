package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/red")
    public String hello(Model model) {
        model.addAttribute("message", "Hello from Thymeleaf!");
        return "red"; // looks for hello.html
    }

    @GetMapping("/welcome")
    public String wel(Model model) {
        model.addAttribute("message", "tang ina mo ");
        return "welcome"; // looks for hello.html


    }
    
}

