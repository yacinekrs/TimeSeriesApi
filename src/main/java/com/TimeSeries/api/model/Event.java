package com.TimeSeries.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "date")
    private Date date;

    @Column(name = "valeur")
    private int value;
    @Column(name = "id_serie")
    private long id_serie;
    @ElementCollection
    @Column(name = "comments")
    private Set<String> comments;
}
