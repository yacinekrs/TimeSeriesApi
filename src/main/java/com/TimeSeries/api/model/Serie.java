package com.TimeSeries.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "Serie_temporel")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="serie_id")
    private Long serieId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "id_serie")
    List<Event> event = new ArrayList<>();
}