package com.TimeSeries.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity

public class SeriesEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long seriesInfoId; // Lien vers l'ID de la série
    private Date date;
    private double value;
}
