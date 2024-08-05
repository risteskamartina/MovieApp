package com.example.kinoapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "sediste")
public class Sediste {
    @EmbeddedId
    private SedisteId id_sediste;
    @ManyToOne
    @MapsId("id_kinosala")
    @JoinColumn(name = "id_kinosala", nullable = false)
    private KinoSala id_kinosala; //so posebna klasa deka e kompoziten kluc so embeded nesto!!!!!!!!!!!!!!!!!
    @Column(name = "brojsediste", nullable = false)
    private Integer brojsediste;

    @OneToMany(mappedBy = "sediste", cascade = CascadeType.ALL)
    private List<Rezervacija> rezervacii;
    public Sediste(){
    }

    public Sediste(KinoSala id_kinosala, Integer brojsediste) {
        this.id_kinosala = id_kinosala;
        this.brojsediste = brojsediste;
    }
}
