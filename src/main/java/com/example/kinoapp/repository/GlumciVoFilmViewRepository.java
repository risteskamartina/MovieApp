package com.example.kinoapp.repository;

import com.example.kinoapp.model.FilmProekciiView;
import com.example.kinoapp.model.GlumciVoFilmView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GlumciVoFilmViewRepository extends JpaRepository<GlumciVoFilmView, Integer> {
    List<GlumciVoFilmView> findByIdFilm(Integer idFilm);
}
