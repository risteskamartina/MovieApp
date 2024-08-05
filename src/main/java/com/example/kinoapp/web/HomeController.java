package com.example.kinoapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("home")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("access_denies")
    public String accessDeniedPage(Model model){
        return "index";
    }
}
