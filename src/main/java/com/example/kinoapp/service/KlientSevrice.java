package com.example.kinoapp.service;

import com.example.kinoapp.model.Klient;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface KlientSevrice extends UserDetailsService {
    Klient login(String username, String password);
    Klient register(String ime, String prezime, String username, String password, String email, String telefon);


}
