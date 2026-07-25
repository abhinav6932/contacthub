package com.scm.contacthub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class pageController {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page Handler");

        // sending data to view
        model.addAttribute("message", "Welcome to the Home Page!");
        model.addAttribute("youtubeChannel", "learn spring boot with abhinav");
        model.addAttribute("GitHubRepository", "https://github.com/abhinav6932/");
        return "home";
    }

    //about route
    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About page Handler");
        return "about";
    }


    // services route
    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Services page Handler");
        return "services";
    }

    // contact route
    @GetMapping("/contact")
    public String contactPage() {
        System.out.println("Contact page Handler");
        return "contact";
    }

    // login route
    @GetMapping("/login")
    public String loginPage() {
        System.out.println("Login page Handler");
       return "login";
    }

    // register route
    @GetMapping("/register")
    public String registerPage() {  
        System.out.println("Register page Handler");
        return "register";
    }
    

}
