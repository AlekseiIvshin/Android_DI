package com.alekseiivshin.samples.android.androidannotations.weather.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aleksei Ivshin
 * on 04.07.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

    public float speed;
}
