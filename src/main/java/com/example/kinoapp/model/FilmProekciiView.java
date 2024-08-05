package com.example.kinoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class FilmProekciiView {
    @Id
    private Integer idProekcija;
    private LocalDate datum;
    private String vreme_pocetok;
    private String tip_proekcija;
    private int cena;
    private Integer idFilm;
    private String film_naslov;
    private String kino_ime;
    private int broj_na_sala;
}
