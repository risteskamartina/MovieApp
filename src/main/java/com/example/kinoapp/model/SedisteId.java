package com.example.kinoapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class SedisteId implements Serializable {
    @Column(name = "id_sediste")
    private Integer id_sediste;


    @Column(name = "id_kinosala")
    private Integer id_kinosala;

    public SedisteId() {
    }

    public SedisteId(Integer id_sediste, Integer id_kinosala) {
        this.id_sediste = id_sediste;
        this.id_kinosala = id_kinosala;
    }
}
