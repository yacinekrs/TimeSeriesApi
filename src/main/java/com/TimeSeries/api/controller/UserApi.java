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
        User userbdd = userRepository.findByUsername(user.getUsername());
        if(userbdd != null) return "userExists";
        else userRepository.save(user);
        return "login";
    }
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @PostMapping("/login")
    public String login(User user) {
        User user1 = null ;
        user1 = userRepository.findByUsername(user.getUsername());
        boolean passwordIsEqual=String.valueOf(user1.getPassword()).equals(String.valueOf(user.getPassword().hashCode()));
        if(user1!=null && passwordIsEqual) return "works";
        else                           return "worknot";
    }



}

