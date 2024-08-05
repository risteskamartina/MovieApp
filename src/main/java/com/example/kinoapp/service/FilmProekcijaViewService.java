package com.example.kinoapp.service;

import com.example.kinoapp.model.FilmProekciiView;

import java.util.List;

public interface FilmProekcijaViewService {
List<FilmProekciiView> findAllByFilm(Integer id_film);
}
