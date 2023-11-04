package com.TimeSeries.api.TimeSeriesapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "YYY")
public class SeriesEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long seriesInfoId; // Lien vers l'ID de la série
    private Date date;
    private double value;
}
