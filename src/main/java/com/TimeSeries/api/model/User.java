package com.TimeSeries.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "utilisateur")
    public class User {

    @Id
    @Column(name = "nom_util")
    private String id;
    @Column(name = "mdps")
    private String password; // In a real-world application, consider using password hashing

    @Column(name = "Role")
    private String role; // In a real-world application, consider using password hashing

    @ElementCollection
    @Column(name = "series")
    private Set<Long> series;

    public void addSerie(Long serie){
        this.series.add(serie);
    }
        // getters and setter
}



