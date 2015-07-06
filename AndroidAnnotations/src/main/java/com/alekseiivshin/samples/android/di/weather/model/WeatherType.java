package com.alekseiivshin.samples.android.di.weather.model;

import android.text.TextUtils;

/**
 * Created by Aleksei Ivshin
 * on 04.07.2015.
 */
public enum WeatherType {

    NONE("none"), SUNNY("sunny"), CLOUDY("clouds");

    private final String weatherTypeName;

    WeatherType(String name) {
        if("unknown".equals(getByName(name).getWeatherType())) {
            weatherTypeName = "unknown";
        }else{
            weatherTypeName = name;
        }

    }

    public String getWeatherType(){
        return weatherTypeName;
    }

    public static WeatherType getByName(String name){
        if(TextUtils.isEmpty(name)){
            return NONE;
        }
        for(WeatherType type: WeatherType.values()){
            if(name.equalsIgnoreCase(type.getWeatherType())){
                return type;
            }
        }
        return NONE;
    }
}
