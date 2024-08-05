package com.example.kinoapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "film")
public class Film {
    @Id
    private Integer id_film;
    @Column(name = "opis", length = 5000)
    private String opis;
    @Column(name = "naslov", nullable = false)
    private String naslov;
    @Column(name = "rejting", length = 5)
    private String rejting;
    @Column(name = "vremetraenje", nullable = false)
    private String vremetraenje;
    @Column(name = "zanr", nullable = false)
    private String zanr;
    private String jazik;
    private String slika;

    @ManyToMany
    @JoinTable(
            name = "film_ima_glumci",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_glumec")
    )
    private List<Glumec> glumci;

    public Film(){
    }

    public Film(Integer id_film, String opis, String naslov, String rejting, String vremetraenje, String zanr, String jazik, String slika) {
        this.id_film = id_film;
        this.opis = opis;
        this.naslov = naslov;
        this.rejting = rejting;
        this.vremetraenje = vremetraenje;
        this.zanr = zanr;
        this.jazik = jazik;
        this.slika=slika;
    }

    public void setNaslovFilm(String naslov){this.naslov=naslov;}
    public void setVremetraenje(String vremetraenje){this.vremetraenje=vremetraenje;}
    public void setZanr(String zanr){this.zanr=zanr;}
}
