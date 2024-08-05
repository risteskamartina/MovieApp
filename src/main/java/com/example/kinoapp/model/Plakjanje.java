package com.example.kinoapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "plakjanje")
public class Plakjanje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_plakjanje;
    @Column(name = "datum", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Column(name = "tip", nullable = false)
    private String tip;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Klient klient;

    @OneToOne
    @JoinColumn(name = "id_rezervacija", nullable = false)
    private Rezervacija rezervacija;

    public Plakjanje(){
    }

    public Plakjanje( Date datum, String tip, Klient klient) {
        this.datum = datum;
        this.tip = tip;
        this.klient = klient;
    }
}
