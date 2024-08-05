package com.example.kinoapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Table(name = "klient")
public class Klient implements UserDetails {
    @Column(name = "ime", nullable = false)
    private String ime;
    @Column(name = "prezime", nullable = false)
    private String prezime;
    @Id
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "telefon", length = 30)
    private String telefon;

    public Klient(){
    }

    public Klient( String ime, String prezime, String username, String password, String email, String telefon) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telefon = telefon;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
