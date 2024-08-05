package com.example.kinoapp.service.impl;

import com.example.kinoapp.model.Klient;
import com.example.kinoapp.model.Proekcija;
import com.example.kinoapp.model.Rezervacija;
import com.example.kinoapp.model.Sediste;
import com.example.kinoapp.repository.RezervacijaRespository;
import com.example.kinoapp.service.RezervacijaService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RezervacijaServiceImpl implements RezervacijaService {
    private final RezervacijaRespository rezervacijaRespository;

    public RezervacijaServiceImpl(RezervacijaRespository rezervacijaRespository) {
        this.rezervacijaRespository = rezervacijaRespository;
    }

    @Override
    public List<Rezervacija> findAllRezervaciiByKlient(Klient klient) {
        Optional<Klient> optionalKlient = Optional.ofNullable(klient);
        return rezervacijaRespository.findAllByKlient(optionalKlient);
    }

    @Override
    public Rezervacija create( Proekcija proekcija,Klient klient) {

        Rezervacija rezervacija = new Rezervacija(LocalDate.now(),proekcija,klient);
        return this.rezervacijaRespository.save(rezervacija);
    }
}
