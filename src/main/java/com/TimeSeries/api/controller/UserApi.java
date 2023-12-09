package com.TimeSeries.api.controller;

import com.TimeSeries.api.model.Serie;
import com.TimeSeries.api.model.User;
import com.TimeSeries.api.repository.UserRepository;
import com.TimeSeries.api.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.NoSuchElementException;

@Controller
public class UserApi{

    @Autowired
    private UserRepository userRepository;
    @Autowired
private SeriesService serieService ;
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
    @PostMapping("/users/{user}/{id}")
    public ResponseEntity<User> login2(@PathVariable String user, @PathVariable long id){
        User existingUser = userRepository.findByUsername(user);
        Serie serie = serieService.getSerieById(id).get();

        if (existingUser != null) {
            if(serie != null)
            {   existingUser.addSerie(serie);
                serie.addUser(existingUser);
                userRepository.save(existingUser);
                serieService.updateSerie(serie.getSerieId(),serie);
                return ResponseEntity.ok(existingUser);}
            else throw new NoSuchElementException("the serie doesnot exist");
        } else {
            throw new NoSuchElementException("the user doesnot exist ");
        }

    }
    @GetMapping("/users/{user}")
    public ResponseEntity<User> GetUer(@PathVariable String user){
        User user1 = userRepository.findByUsername(user);
        if(user1 != null) return ResponseEntity.ok(user1) ;
        else return null;
    }
}

