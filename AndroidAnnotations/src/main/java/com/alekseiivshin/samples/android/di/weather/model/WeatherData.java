package com.alekseiivshin.samples.android.di.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Aleksei Ivshin
 * on 04.07.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

    @JsonProperty("weather")
    public List<WeatherDesc> weatherList;

    public BaseData main;

    public Wind wind;

    @JsonProperty("dt")
    public long timestamp;

    @JsonProperty("name")
    public String city;

    public WeatherDesc getMainWeather() {
        if (weatherList != null && !weatherList.isEmpty()) {
            return weatherList.get(0);
        }
        return new WeatherDesc();
    }
}
