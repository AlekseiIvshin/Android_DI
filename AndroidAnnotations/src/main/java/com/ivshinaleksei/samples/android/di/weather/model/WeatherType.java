package com.ivshinaleksei.samples.android.di.weather.model;

import android.text.TextUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.lang.reflect.WildcardType;

/**
 * Created by Aleksei Ivshin
 * on 04.07.2015.
 */
public enum WeatherType {

    NONE("none"), SUNNY("sunny"), CLOUDY("clouds"), UNKNOWN("unknown");

    private final String weatherTypeName;

    WeatherType(String name) {
        if("unknown".equals(getByName(name).value())) {
            weatherTypeName = "unknown";
        }else{
            weatherTypeName = name;
        }

    }

    public String value(){
        return weatherTypeName;
    }

    public static WeatherType getByName(String name){
        for(WeatherType type: values()){
            if(TextUtils.equals(type.value(), name)){
                return type;
            }
        }
        return UNKNOWN;
    }
}
