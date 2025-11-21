package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("loginForm") User form, Model model) {

        String username = form.getUsername();
        String password = form.getPassword();

        // 🔥 Command line log
        System.out.println("==================================");
        System.out.println("Username submitted: " + username);
        System.out.println("Password submitted: " + password);
        System.out.println("==================================");

        boolean success = userService.validateUser(username, password);

        if (success) {
            model.addAttribute("message", "Safe kang kupal ka Withdrawhin Muna Baka Makuha Pa Yan Ng Di Mo Nakikilala");
            return "red"; // your next page
        } else {
            model.addAttribute("error", "Bilisan Mo Yung Laman Ng Banko Mo Ni Nanakaw Na Ng Mga Buhaya .");
            return "login";
        }
    }
    @GetMapping("/Register")
public String showRegister(Model model) {
    model.addAttribute("RegisterForm", new User());
    return "Register";
}
}
