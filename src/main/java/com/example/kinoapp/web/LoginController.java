package com.example.kinoapp.web;

import com.example.kinoapp.model.Klient;
import com.example.kinoapp.model.exceptions.InvalidUserCredentialsException;
import com.example.kinoapp.service.KlientSevrice;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final KlientSevrice klientSevrice;

    public LoginController(KlientSevrice klientSevrice) {
        this.klientSevrice = klientSevrice;
    }
    @GetMapping
    public String getLoginPage(){
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model){ //kaj model go izbirame kako interface ne ko klasa!
        Klient klient = null;
        try {
            klient = this.klientSevrice.login(request.getParameter("username"),request.getParameter("password"));
            request.getSession().setAttribute("klient",klient);
            return "redirect:/movies";
        }
        catch (InvalidUserCredentialsException exception){
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }
}
