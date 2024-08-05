package com.example.kinoapp.repository;

import com.example.kinoapp.model.Klient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KlientRepository extends JpaRepository<Klient,Integer> {
    Optional<Klient> findByUsernameAndPassword(String username, String password);
    Optional<Klient> findByUsername(String username);
}
