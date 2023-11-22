package com.TimeSeries.api.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SeriesInfo {

    private ArrayList<SeriesEvent> event;
    //@Column(name = "first_name")
    private String title;
    //@Column(name = "last_name")
    private String description;
}