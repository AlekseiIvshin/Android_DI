package com.eficksan.samples.android.butterknife.butterknife;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {
    private static final int NOTIFICATION_ID = 1;
    @Bind(R.id.refresh)
    ImageButton refresh;

    @Bind(R.id.remind_me)
    ImageButton remindMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Needs for right injection
        ButterKnife.bind(this);
    }

    @OnClick(R.id.refresh)
    public void refreshWeather() {
        Toast.makeText(MainActivity.this, "Refresh views", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.remind_me)
    public void remindMe() {
        Notification.Builder builder = new Notification.Builder(MainActivity.this);
        builder.setContentTitle("Weather reminder")
                .setContentText("Functional did not implemented!")
                .setSmallIcon(R.drawable.ic_weather_notification);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

}
