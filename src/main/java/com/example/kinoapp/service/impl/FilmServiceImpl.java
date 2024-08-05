package com.example.kinoapp.service.impl;

import com.example.kinoapp.model.Film;
import com.example.kinoapp.model.Glumec;
import com.example.kinoapp.repository.FilmRepository;
import com.example.kinoapp.repository.GlumecRepository;
import com.example.kinoapp.service.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final GlumecRepository glumecRepository;


    public FilmServiceImpl(FilmRepository filmRepository, GlumecRepository glumecRepository) {
        this.filmRepository = filmRepository;
        this.glumecRepository = glumecRepository;
    }

    @Override
    public List<Glumec> findGlumciVoFilm(String naslov) {
        Film film = filmRepository.findByNaslov(naslov);
        return glumecRepository.findAll();
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film findById(Integer id) {
        return this.filmRepository.findById(id).orElseThrow();
    }

    @Override
    public Film save(Film film) {
        return this.filmRepository.save(film);
    }
}
