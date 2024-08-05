package com.example.kinoapp.repository;

import com.example.kinoapp.model.RezervaciiView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RezervaciiViewRepository extends JpaRepository<RezervaciiView,Integer> {
    List<RezervaciiView> findByUsername(String username);
}
