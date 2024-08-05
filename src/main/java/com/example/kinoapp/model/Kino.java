package com.example.kinoapp.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "kino")
public class Kino {
    @Id
    private Integer id_kino;
    @Column(name = "ime", nullable = false)
    private String ime;
    @Column(name = "lokacija", nullable = false)
    private String lokacija;


    public Kino(){
    }
    public Kino(Integer id_kino, String ime, String lokacija) {
        this.id_kino = id_kino;
        this.ime = ime;
        this.lokacija = lokacija;
    }
    public void setImeKino(String ime){this.ime=ime;}
}
