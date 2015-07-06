package com.alekseiivshin.samples.android.di.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Aleksei Ivshin
 * on 04.07.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseData {
    @JsonProperty("temp")
    public float temperature;

    public float pressure;

    public int humidity;
}
