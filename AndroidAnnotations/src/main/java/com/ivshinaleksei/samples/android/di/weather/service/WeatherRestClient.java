package com.ivshinaleksei.samples.android.di.weather.service;

import com.ivshinaleksei.samples.android.di.weather.model.WeatherData;

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
