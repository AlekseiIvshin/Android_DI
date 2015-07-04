package com.ivshinaleksei.samples.android.di.weather.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Aleksei Ivshin
 * on 04.07.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDesc {

    public final WeatherType weatherType;
    public final String description;

    @JsonCreator
    public WeatherDesc(@JsonProperty("main") String type, String description){
       weatherType = WeatherType.getByName(type);
        this.description = description;
    }
}
