package com.example.kinoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class GlumciVoFilmView {
    @Id
    private Integer idGlumec;
    private String imeGlumec;
    private String prezimeGlumec;
    private Integer idFilm;
}
