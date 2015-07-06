package com.alekseiivshin.samples.android.di.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Aleksei Ivshin
 * on 04.07.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDesc {

    @JsonProperty("main")
    public String weatherType;
    public String description;

}
