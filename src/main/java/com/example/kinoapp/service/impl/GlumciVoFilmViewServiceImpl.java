package com.example.kinoapp.service.impl;

import com.example.kinoapp.model.GlumciVoFilmView;
import com.example.kinoapp.repository.GlumciVoFilmViewRepository;
import com.example.kinoapp.service.GlumciVoFilmViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlumciVoFilmViewServiceImpl implements GlumciVoFilmViewService {
    private final GlumciVoFilmViewRepository glumciVoFilmViewRepository;

    public GlumciVoFilmViewServiceImpl(GlumciVoFilmViewRepository glumciVoFilmViewRepository) {
        this.glumciVoFilmViewRepository = glumciVoFilmViewRepository;
    }

    @Override
    public List<GlumciVoFilmView> findAllByFilm(Integer id_film) {
        return this.glumciVoFilmViewRepository.findByIdFilm(id_film);
    }
}
