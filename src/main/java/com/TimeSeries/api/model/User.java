package com.TimeSeries.api.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "utilisateur")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

    @Column(name = "nom_util")

    private String username;
    @Column(name = "mdps")

    private String password; // In a real-world application, consider using password hashing

        // getters and setters
    }


