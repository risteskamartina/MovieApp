package com.example.kinoapp.web;

import com.example.kinoapp.model.Klient;
import com.example.kinoapp.model.RezervaciiView;
import com.example.kinoapp.model.Rezervacija;
import com.example.kinoapp.model.exceptions.ClientNotFoundException;
import com.example.kinoapp.repository.KlientRepository;
import com.example.kinoapp.repository.RezervaciiViewRepository;
import com.example.kinoapp.repository.RezervacijaRespository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final KlientRepository klientRepository;
    private final RezervacijaRespository rezervacijaRespository;
    private final RezervaciiViewRepository rezervaciiViewRepository;

    public ProfileController(KlientRepository klientRepository, RezervacijaRespository rezervacijaRespository, RezervaciiViewRepository rezervaciiViewRepository) {
        this.klientRepository = klientRepository;
        this.rezervacijaRespository = rezervacijaRespository;
        this.rezervaciiViewRepository = rezervaciiViewRepository;
    }

    @GetMapping("/info")
    public String getClientInfo(Model model, HttpServletRequest req){
        String username=req.getRemoteUser();

        Klient klient = this.klientRepository.findByUsername(username).orElseThrow(()->new ClientNotFoundException(username));
        List<RezervaciiView> rents=this.rezervaciiViewRepository.findByUsername(username);
        model.addAttribute("klient", klient);
        model.addAttribute("rents",rents);

        return "profile";
    }
}
