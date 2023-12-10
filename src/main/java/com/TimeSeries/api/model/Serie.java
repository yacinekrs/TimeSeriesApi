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
    @JoinColumn()
    List<Event> event = new ArrayList<>();

  @ElementCollection
  @Column(name = "series")

  private List<String> users ;

  public void addUser(String username){
   this.users.add(username);
  }
}