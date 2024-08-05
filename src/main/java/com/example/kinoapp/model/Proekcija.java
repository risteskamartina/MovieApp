package com.example.kinoapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "proekcija")

public class Proekcija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proekcija;
    @Column(name = "datum", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Column(name = "pocetok", nullable = false)
    private String pocetok;
    @Column(name = "kraj", nullable = false)
    private String kraj;
    @Column(name = "tip", nullable = false)
    private String tip;
    @Column(name = "cena", nullable = false)
    private Integer cena;

    @ManyToOne
    @JoinColumn(name = "id_kinosala", nullable = false)
    private KinoSala kinoSala;

    @ManyToOne
    @JoinColumn(name = "id_film", nullable = false)
    private Film film;

    public Proekcija(){
    }

    public Proekcija(Date datum, String pocetok, String kraj, String tip, Integer cena, KinoSala kinoSala, Film film) {
        this.datum = datum;
        this.pocetok = pocetok;
        this.kraj = kraj;
        this.tip = tip;
        this.cena = cena;
        this.kinoSala = kinoSala;
        this.film = film;
    }

    public void setDatum(Date datum){this.datum=datum; }
    public void setPocetok(String pocetok){this.pocetok=pocetok;}
    public void setKraj(String kraj){this.kraj=kraj;}
    public void setTip(String tip){this.tip=tip;}
    public void setCena(Integer cena){this.cena=cena;}
    public KinoSala getKinoSala(){return kinoSala;}
    public Film getFilm(){return film;}

    public void setKinoSala(KinoSala kinoSala) {
        this.kinoSala=kinoSala;
    }

    public void setFilm(Film film) {
        this.film=film;
    }
}
