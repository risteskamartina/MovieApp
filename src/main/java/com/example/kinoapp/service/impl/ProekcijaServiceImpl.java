package com.example.kinoapp.service.impl;

import com.example.kinoapp.model.*;
import com.example.kinoapp.model.exceptions.InvalidProectionIdException;
import com.example.kinoapp.repository.ProekcijaRepository;
import com.example.kinoapp.service.ProekcijaService;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class ProekcijaServiceImpl implements ProekcijaService {
    private final ProekcijaRepository proekcijaRepository;

    public ProekcijaServiceImpl(ProekcijaRepository proekcijaRepository) {
        this.proekcijaRepository = proekcijaRepository;
    }

    @Override
    public List<Proekcija> listAll() {
        return this.proekcijaRepository.findAll();
    }

    @Override
    public Proekcija findById(Integer id) {
        return this.proekcijaRepository.findById(id).orElseThrow(InvalidProectionIdException::new);
    }

    @Override
    public Proekcija create(KinoSala kinoSala, Film film, Data datum, String pocetok, String kraj, String tip, Integer cena) {
        Proekcija proekcija = new Proekcija();
        proekcija.setKinoSala(kinoSala);
        proekcija.setFilm(film);
        proekcija.setDatum((Date) datum);
        proekcija.setPocetok(pocetok);
        proekcija.setKraj(kraj);
        proekcija.setTip(tip);
        proekcija.setCena(cena);

        return this.proekcijaRepository.save(proekcija);
    }

    @Override
    public Proekcija update(Integer id, KinoSala kinoSala, Film film, Data datum, String pocetok, String kraj, String tip, Integer cena) {
        Proekcija proekcija = this.findById(id);
        proekcija.setKinoSala(kinoSala);
        proekcija.setFilm(film);
        proekcija.setDatum((Date) datum);
        proekcija.setPocetok(pocetok);
        proekcija.setKraj(kraj);
        proekcija.setTip(tip);
        proekcija.setCena(cena);

        return this.proekcijaRepository.save(proekcija);
    }

    @Override
    public Proekcija delete(Integer id) {
        Proekcija proekcija = this.findById(id);
        this.proekcijaRepository.delete(proekcija);
        return proekcija;
    }

}
