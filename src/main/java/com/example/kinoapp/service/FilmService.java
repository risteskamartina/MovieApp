package com.example.kinoapp.service;

import com.example.kinoapp.model.Film;
import com.example.kinoapp.model.Glumec;

import java.util.List;

public interface FilmService {
    List<Glumec> findGlumciVoFilm(String naslov);
    List<Film> findAll();
    Film findById(Integer id);
    Film save(Film film);
}
