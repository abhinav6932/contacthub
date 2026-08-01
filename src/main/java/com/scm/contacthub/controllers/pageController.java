package com.scm.contacthub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.contacthub.entities.User;
import com.scm.contacthub.forms.UserForm;
import com.scm.contacthub.helpers.Message;
import com.scm.contacthub.helpers.MessageType;
import com.scm.contacthub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;





@Controller
public class pageController {

    @Autowired
    private UserService userService;

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
    public String register(Model model) {  
       
        UserForm userForm = new UserForm();
        // default data bhi add kr sakte h
        //  userForm.setName("Abhinav");
        //  userForm.setEmail("abhinav123@gmail.com");
        //  userForm.setPassword("Abhinav123");
        //  userForm.setPhoneNumber("9135546932");
        //  userForm.setAbout("helow everyone my name is abhinav kumar an i'm learning springboot nowdays...");

        model.addAttribute("userForm", userForm);
        return "register";
    }

    //processing register

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){

        //fetch form data
        //UserForm
        System.out.println(userForm);
        //validate from data

        if(rBindingResult.hasErrors()){
            return "register";
        }


        // todo: in next vdo validate form data


        // save to database

        // userForm -> user
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://stock.adobe.com/search?k=%22default+profile+picture%22")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://stock.adobe.com/search?k=%22default+profile+picture%22");

        User savedUser = userService.saveUser(user);
        System.out.println("user saved..");

        //message = "registration successfull"

        //add the message:

        Message message =  Message.builder().content("Registration Successfull").type(MessageType.blue).build();

        session.setAttribute("message", message);

        //return messa
        return "redirect:/register";
    }
    

}
