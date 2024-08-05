package com.example.kinoapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "kinosala")
public class KinoSala {
    @Id
    private Integer id_kinosala;
    @Column(name = "kapacitet", nullable = false)
    private String kapacitet;
    @Column(name = "brojnasala", nullable = false)
    private Integer brojnasala;
    @ManyToOne
    @JoinColumn(name = "id_kino", nullable = false)
    private Kino kino;

    public KinoSala(){
    }

    public KinoSala(Integer id_kinosala, String kapacitet, Integer brojnasala, Kino kino) {
        this.id_kinosala = id_kinosala;
        this.kapacitet = kapacitet;
        this.brojnasala = brojnasala;
        this.kino = kino;
    }
}
