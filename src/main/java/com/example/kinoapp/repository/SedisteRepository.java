package com.example.kinoapp.repository;

import com.example.kinoapp.model.Sediste;
import com.example.kinoapp.model.SedisteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedisteRepository extends JpaRepository <Sediste, SedisteId> {
}
