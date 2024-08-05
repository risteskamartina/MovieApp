package com.example.kinoapp.service;

import com.example.kinoapp.model.Klient;
import com.example.kinoapp.model.Proekcija;
import com.example.kinoapp.model.Rezervacija;
import com.example.kinoapp.model.Sediste;

import java.util.Date;
import java.util.List;

public interface RezervacijaService {
    List<Rezervacija> findAllRezervaciiByKlient(Klient klient);
    Rezervacija create( Proekcija proekcija, Klient klient);
}
