package com.alekseiivshin.samples.android.androidannotations;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.alekseiivshin.samples.android.androidannotations.weather.model.WeatherData;
import com.alekseiivshin.samples.android.androidannotations.weather.service.WeatherRestClient;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

@EActivity
public class MainActivity extends Activity {

    private static final String LOAD_WEATHER_TASK = "load.weather.task";

    private static final int NOTIFICATION_DELAY = 60 * 1000;
    private static final int NOTIFICATION_ID = 1;

    @SystemService
    NotificationManager mNotificationManager;

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

    @Click(R.id.remind_me)
    protected void remindMeLater() {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Weather")
                .setContentText(mWeatherDescription.getText().toString())
                .setSmallIcon(R.drawable.ic_weather_notification);
        remind(builder.build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadWeatherData();
    }

    @Background(id = LOAD_WEATHER_TASK, delay = 6000)
    void loadWeatherData() {
        // TODO: get city data and localization from anywhere.
        WeatherData weatherData = mWeatherRestClient.getWeather("Izhevsk", "ru");
        fillViews(weatherData);
    }

    @Background(delay = NOTIFICATION_DELAY)
    void remind(Notification notification) {
        mNotificationManager.notify(NOTIFICATION_ID, notification);
    }

    @UiThread
    void fillViews(WeatherData weatherData) {
        mWeatherDescription.setText(weatherData.getMainWeather().description);
        mTemperature.setText(getResources().getString(R.string.temperature,
                weatherData.main.temperature));
        mWind.setText(getResources().getString(R.string.wind, weatherData.wind.speed));

        updateWeatherImage(weatherData.getMainWeather().weatherType);
    }

    protected void updateWeatherImage(String type) {
        switch (type.toLowerCase()) {
            case "clouds":
                mWeatherIcon.setImageResource(R.drawable.ic_weather_cloudy);
                break;
            case "clear":
                mWeatherIcon.setImageResource(R.drawable.ic_weather_sunny);
                break;
            default:
                mWeatherIcon.setImageResource(R.drawable.ic_weather_placeholder);
        }
    }
}
