package com.TimeSeries.api.TimeSeriesapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "XXX")
public class SeriesInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "first_name")
    private String title;
    //@Column(name = "last_name")
    private String description;
}