package com.example.kinoapp.repository;

import com.example.kinoapp.model.Film;
import com.example.kinoapp.model.KinoSala;
import com.example.kinoapp.model.Proekcija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProekcijaRepository extends JpaRepository <Proekcija,Integer> {

    List<Proekcija> findAllByKinoSala (KinoSala kinosala);

}
