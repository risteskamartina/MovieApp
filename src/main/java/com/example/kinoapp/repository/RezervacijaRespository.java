package com.example.kinoapp.repository;

import com.example.kinoapp.model.Klient;
import com.example.kinoapp.model.Proekcija;
import com.example.kinoapp.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RezervacijaRespository extends JpaRepository<Rezervacija,Integer> {
    List<Rezervacija> findAllByKlient(Optional<Klient> klient);

    List<Rezervacija> findAllByProekcija (Proekcija proekcija);

}
