package com.TimeSeries.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "utilisateur")
    public class User {

    @Id
    @Column(name = "nom_util")
    private String username;
    @Column(name = "mdps")
    private String password; // In a real-world application, consider using password hashing

    @ManyToMany
    @JoinTable(
            name = "user_series",
            joinColumns = @JoinColumn(name = "nom_util"),
            inverseJoinColumns = @JoinColumn(name = "serie_id"))
    private Set<Serie> series = new HashSet<>();
        // getters and setters
    }


