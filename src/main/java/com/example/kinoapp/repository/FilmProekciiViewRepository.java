package com.example.kinoapp.repository;

import com.example.kinoapp.model.FilmProekciiView;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FilmProekciiViewRepository extends JpaRepository<FilmProekciiView,Integer> {
    List<FilmProekciiView> findByIdFilm(Integer idFilm);
}
