package com.alekseiivshin.samples.android.androidanotations;

import android.app.Notification;
import android.app.NotificationManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.inject.Inject;

import roboguice.activity.RoboActivity;
import roboguice.context.event.OnCreateEvent;
import roboguice.event.EventManager;
import roboguice.event.Observes;
import roboguice.inject.ContentView;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int NOTIFICATION_ID = 1;

    @InjectView(R.id.refresh)
    ImageView refreshButton;

    @InjectView(R.id.remind_me)
    ImageView remindButton;

    @InjectResource(R.string.refresh_operation_desc)
    String refreshOperationDescription;

    @InjectResource(R.string.remind_me_later)
    String remindDescription;

    @Inject
    NotificationManager notificationManager;

    @Inject
    EventManager eventManager;

    public void onResumeEventHandler(@Observes OnCreateEvent event) {
        Log.d(TAG, "Activity created!");

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, refreshOperationDescription, Toast.LENGTH_LONG).show();
            }
        });

        remindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventManager.fire(new RemindMeLaterEvent(remindDescription));
            }
        });
    }

    public void onRemindMeLaterEvent(@Observes RemindMeLaterEvent event) {
        Notification.Builder builder = new Notification.Builder(MainActivity.this);
        builder.setContentTitle(remindDescription)
                .setContentText(event.message)
                .setSmallIcon(R.drawable.ic_weather_notification);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    class RemindMeLaterEvent {
        public final String message;

        RemindMeLaterEvent(String message) {
            this.message = message;
        }
    }
}
