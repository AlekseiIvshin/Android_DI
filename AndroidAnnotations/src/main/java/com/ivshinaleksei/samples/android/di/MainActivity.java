package com.ivshinaleksei.samples.android.di;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ivshinaleksei.samples.android.di.weather.model.WeatherData;
import com.ivshinaleksei.samples.android.di.weather.service.WeatherRestClient;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

@EActivity
public class MainActivity extends Activity {

    private static final String LOAD_WEATHER_TASK = "load.weather.task";

    @RestService
    WeatherRestClient mWeatherRestClient;

    @ViewById(R.id.ic_weather)
    ImageView mWeatherIcon;

    @ViewById(R.id.weather_description)
    TextView mWeatherDescription;

    @ViewById(R.id.temperature)
    TextView mTemperature;

    @ViewById(R.id.wind)
    TextView mWind;

    @Click(R.id.refresh)
    protected void refreshWeatherData() {
        loadWeatherData();
    }

    @Click(R.id.save_to_db)
    protected void saveWeatherDataToDataBase() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Background(id = LOAD_WEATHER_TASK)
    void loadWeatherData() {
        // TODO: get city data and localization from anywhere.
        WeatherData weatherData = mWeatherRestClient.getWeather("Izhevsk", "ru");
        fillViews(weatherData);
    }

    @UiThread
    void fillViews(WeatherData weatherData) {
        mWeatherDescription.setText(weatherData.getMainWeather().description);
        mTemperature.setText(String.valueOf(weatherData.main.temperature));
        mWind.setText(String.valueOf(weatherData.wind.speed));
    }
}
