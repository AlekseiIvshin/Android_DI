package com.ivshinaleksei.samples.android.di;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity
public class MainActivity extends Activity {

    @ViewById(R.id.ic_weather)
    ImageView mWeatherIcon;

    @ViewById(R.id.weather_description)
    TextView mWeatherDescription;

    @ViewById(R.id.temperature)
    TextView mTemperature;

    @ViewById(R.id.wind)
    TextView mWind;

    @Click(R.id.refresh)
    private void refreshWeatherData(){

    }

    @Click(R.id.save_to_db)
    private void saveWeatherDataToDataBase(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
