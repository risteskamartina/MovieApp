package com.example.kinoapp.web;

import com.example.kinoapp.model.exceptions.InvalidArgumentsException;
import com.example.kinoapp.service.KlientSevrice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final KlientSevrice klientSevrice;

    public RegisterController(KlientSevrice klientSevrice) {
        this.klientSevrice = klientSevrice;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String ime,
                           @RequestParam String prezime,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email,
                           @RequestParam String telefon){
        try{
            this.klientSevrice.register(ime,prezime,username,password,email,telefon);
            return "redirect:/login";
        }
        catch (InvalidArgumentsException exception){
            return "redirect:/register?error=" + exception.getMessage();
        }
    }
}
