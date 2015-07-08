package com.alekseiivshin.samples.android.androidannotations.weather.service;

import com.alekseiivshin.samples.android.androidannotations.weather.model.WeatherData;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by Aleksei Ivshin
 * on 04.07.2015.
 */
@Rest(rootUrl = "http://api.openweathermap.org/data/2.5", converters = {MappingJackson2HttpMessageConverter.class})
public interface WeatherRestClient {
    @Get("/weather?q={city},{locale}")
    WeatherData getWeather(String city, String locale);
}
