package com.example.kinoapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "rezervacija")
public class Rezervacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rezervacija;
    @Column(name = "datum", nullable = false)
    private LocalDate datum;



    @ManyToOne
    @JoinColumn(name = "id_proekcija", nullable = false)
    private Proekcija proekcija;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_sediste", referencedColumnName = "id_sediste"),
            @JoinColumn(name = "id_kinosala", referencedColumnName = "id_kinosala")
    })
    private Sediste sediste;



    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Klient klient;

    public Rezervacija(){
    }

    public Rezervacija(LocalDate datum, Proekcija proekcija, Klient klient) {
        this.datum = datum;
        this.proekcija = proekcija;
        this.klient = klient;
    }
}
