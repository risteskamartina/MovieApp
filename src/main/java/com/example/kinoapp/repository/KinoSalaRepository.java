package com.example.kinoapp.repository;

import com.example.kinoapp.model.KinoSala;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KinoSalaRepository extends JpaRepository<KinoSala, Integer> {

}
