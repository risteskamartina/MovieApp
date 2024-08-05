package com.example.kinoapp.service;

import com.example.kinoapp.model.FilmProekciiView;
import com.example.kinoapp.model.GlumciVoFilmView;

import java.util.List;

public interface GlumciVoFilmViewService {
    List<GlumciVoFilmView> findAllByFilm(Integer id_film);
}
