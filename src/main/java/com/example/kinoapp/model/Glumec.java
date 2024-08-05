package com.example.kinoapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "glumec")
public class Glumec {
    @Id
    private Integer id_glumec;
    @Column(name = "ime", nullable = false)
    private String ime;
    @Column(name = "prezime", nullable = false)
    private String prezime;

    @ManyToMany(mappedBy = "glumci")
    private List<Film> filmovi;
    public Glumec(){
    }

    public Glumec(Integer id_glumec, String ime, String prezime) {
        this.id_glumec = id_glumec;
        this.ime = ime;
        this.prezime = prezime;
    }

}
