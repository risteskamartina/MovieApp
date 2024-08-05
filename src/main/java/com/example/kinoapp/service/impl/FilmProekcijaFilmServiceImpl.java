package com.example.kinoapp.service.impl;

import com.example.kinoapp.model.FilmProekciiView;
import com.example.kinoapp.repository.FilmProekciiViewRepository;
import com.example.kinoapp.service.FilmProekcijaViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmProekcijaFilmServiceImpl implements FilmProekcijaViewService {
    private final FilmProekciiViewRepository filmProekciiViewRepository;

    public FilmProekcijaFilmServiceImpl(FilmProekciiViewRepository filmProekciiViewRepository) {
        this.filmProekciiViewRepository = filmProekciiViewRepository;
    }

    @Override
    public List<FilmProekciiView> findAllByFilm(Integer id_film) {
        return this.filmProekciiViewRepository.findByIdFilm(id_film);
    }
}
