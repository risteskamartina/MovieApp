package com.example.kinoapp.service;

import com.example.kinoapp.model.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import javax.xml.crypto.Data;
import java.util.List;

public interface ProekcijaService {
    List<Proekcija> listAll();
    Proekcija findById(Integer id);
    Proekcija create(KinoSala kinoSala, Film film, Data datum, String pocetok, String kraj, String tip, Integer cena);
    Proekcija update(Integer id,KinoSala kinoSala, Film film, Data datum, String pocetok, String kraj, String tip, Integer cena);
    Proekcija delete(Integer id);

}
