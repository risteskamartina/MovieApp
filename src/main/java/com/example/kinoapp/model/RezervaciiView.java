package com.example.kinoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class RezervaciiView {

    @Id
    private Integer id_rezervacija;
    private String ime_kino;
    private Integer brojnasala;
    private String username;
    private Integer cena;
    private String pocetok;
    private LocalDate datum;
    private String naslov;
}