package com.example.kinoapp.service.impl;

import com.example.kinoapp.model.Klient;
import com.example.kinoapp.model.exceptions.InvalidArgumentsException;
import com.example.kinoapp.model.exceptions.InvalidUserCredentialsException;
import com.example.kinoapp.model.exceptions.UsernameAlreadyExistException;
import com.example.kinoapp.repository.KlientRepository;
import com.example.kinoapp.service.KlientSevrice;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KlientServiceImpl implements KlientSevrice {
    private final KlientRepository klientRepository;
    private final PasswordEncoder passwordEncoder;

    public KlientServiceImpl(KlientRepository klientRepository, PasswordEncoder passwordEncoder) {
        this.klientRepository = klientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Klient login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentsException();
        }
        System.out.println("Attempting login with username: " + username);

        return klientRepository.findByUsernameAndPassword(username, password).orElseThrow(() -> {
            System.out.println("Invalid user credentials for username: " + username);
            return new InvalidUserCredentialsException();});

    }

    @Override
    public Klient register(String ime, String prezime, String username, String password, String email, String telefon) {
        if (ime == null || prezime == null || ime.isEmpty() || prezime.isEmpty() || username == null || username.isEmpty() || password == null || password.isEmpty() || email == null || email.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        if (this.klientRepository.findByUsername(username).isPresent() || !this.klientRepository.findByUsername(username).isEmpty())
            throw new UsernameAlreadyExistException(username);

        Klient klient = new Klient(ime, prezime, username, passwordEncoder.encode(password), email, telefon);
        return klientRepository.save(klient);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return klientRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
    }

}
