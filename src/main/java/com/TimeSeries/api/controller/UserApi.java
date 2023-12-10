package com.TimeSeries.api.controller;

import com.TimeSeries.api.model.Serie;
import com.TimeSeries.api.model.User;
import com.TimeSeries.api.repository.SeriesRepository;
import com.TimeSeries.api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Controller@RequestMapping("api/user")
public class UserApi{

    @Autowired
    private UserRepository userRepository;
    @Autowired
private SeriesRepository serieRepositary;
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(User user) {
        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        User userbdd = userRepository.findById(user.getId());
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
        user1 = userRepository.findById(user.getId());
        boolean passwordIsEqual = String.valueOf(user1.getPassword()).equals(String.valueOf(user.getPassword().hashCode()));
        if(user1!=null && passwordIsEqual) return "works";
        else                           return "worknot";
    }
    @Transactional
    @PostMapping("/users/{user}/{id}")
    public ResponseEntity<User> login2(@PathVariable String user, @PathVariable long id) throws Exception {
        User existingUser = userRepository.findById(user);
        Serie serie = serieRepositary.findById(id).get();
        if (existingUser != null) {
            if(serie != null)
            {
                if(!existingUser.getSeries().contains(id))
                {
                    existingUser.addSerie(serie.getSerieId());
                    userRepository.save(existingUser);
                    serie.addUser(existingUser.getId());
                    serieRepositary.save(serie);
                }
                else throw new Exception("serie already exists");
               }
            return  ResponseEntity.ok(existingUser);
        } else {
            throw new NoSuchElementException("the element doesnot exist ");
        }

    }
    @GetMapping("/users/{user}")
    public ResponseEntity<User> GetUser(@PathVariable String user){
        User user1 = userRepository.findById(user);
        if(user1 != null) return ResponseEntity.ok(user1) ;
        else return null;
    }
    @GetMapping("/users/{user}/series")
    public ResponseEntity<Object> GetUserSeries(@PathVariable String user){
        User user1 = userRepository.findById(user);
        Set<Long> seriesSet = new HashSet<>();
        Iterable<Serie> series = new HashSet<>();
        if(user1 != null) {
            seriesSet = user1.getSeries();
            series =  serieRepositary.findAllById(seriesSet);
            System.out.println(series.toString());
            return ResponseEntity.ok(series);
        }
        else return null;
    }
}

