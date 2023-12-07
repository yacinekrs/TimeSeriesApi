package com.TimeSeries.api.controller;

import com.TimeSeries.api.model.User;
import com.TimeSeries.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserApi{

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(User user) {
        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        userRepository.save(user);
        return "login"; // Redirect to login page after successful registration
    }
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @PostMapping("/login")
    public String login(User user) {
        User user1 = null ;
        user1 = userRepository.findByUsername(user.getUsername());
        System.out.print(user1.getPassword()+user.getPassword().hashCode());
        if(user1!=null && String.valueOf(user1.getPassword()).equals(String.valueOf(user.getPassword().hashCode())))
        {
            System.out.print("rayan");

            return "works";
        }
        else return "worknot";
    }


}

