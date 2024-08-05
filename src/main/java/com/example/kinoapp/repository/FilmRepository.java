package com.example.kinoapp.repository;

import com.example.kinoapp.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    Film findByNaslov (String naslov);
    List<Film> findAllByZanr (String zanr);
 //   Film findById_film(Integer id);

}
