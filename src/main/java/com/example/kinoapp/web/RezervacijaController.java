package com.example.kinoapp.web;

import com.example.kinoapp.model.*;
import com.example.kinoapp.model.exceptions.InvalidMovieIdException;
import com.example.kinoapp.repository.*;
import com.example.kinoapp.service.FilmService;
import com.example.kinoapp.service.ProekcijaService;
import com.example.kinoapp.service.RezervacijaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class RezervacijaController {
    private final ProekcijaRepository proekcijaRepository;
    private final SedisteRepository sedisteRepository;
    private final RezervacijaRespository rezervacijaRespository;
    private final RezervacijaService rezervacijaService;
    private final FilmService filmService;
    private final KlientRepository klientRepository;
    private final KinoSalaRepository kinoSalaRepository;

    public RezervacijaController(ProekcijaRepository proekcijaRepository, SedisteRepository sedisteRepository, RezervacijaRespository rezervacijaRespository, RezervacijaService rezervacijaService, FilmService filmService, KlientRepository klientRepository,  KinoSalaRepository kinoSalaRepository) {
        this.proekcijaRepository = proekcijaRepository;
        this.sedisteRepository = sedisteRepository;
        this.rezervacijaRespository = rezervacijaRespository;
        this.rezervacijaService = rezervacijaService;
        this.filmService = filmService;
        this.klientRepository = klientRepository;
        this.kinoSalaRepository = kinoSalaRepository;
    }

    @PostMapping("/reservation/{id_proekcija}")
    public String showReservation(@PathVariable Integer id_proekcija,  HttpServletRequest req){
        String username=req.getRemoteUser();
        Klient klient = this.klientRepository.findByUsername(username).orElseThrow();

        Proekcija proekcija =this.proekcijaRepository.findById(id_proekcija).orElseThrow();
        this.rezervacijaService.create(proekcija, klient);
        return "uspesno";
    }

    @PostMapping("/reservation")
    public String create(
                         @RequestParam Integer proekcijaId,
                         @RequestParam String username){
        Proekcija proekcija = this.proekcijaRepository.findById(proekcijaId).orElseThrow();
        Klient username1 = this.klientRepository.findByUsername(username).orElseThrow();
        this.rezervacijaService.create(proekcija,username1);
        return "redirect:/movies";
    }

}
