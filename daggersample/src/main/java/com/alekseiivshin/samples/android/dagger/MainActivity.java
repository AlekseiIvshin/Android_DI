package com.alekseiivshin.samples.android.dagger;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.alekseiivshin.samples.android.dagger.service.DuckService;

import javax.inject.Inject;

public class MainActivity extends Activity {

    @Inject
    DuckService duckService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (DaggerSampleApp.getObjectGraph() != null) {
            DaggerSampleApp.getObjectGraph().inject(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Duck: name = " + duckService.getDuckName() + "; hp = " + duckService.getHealthPoints() + ";", Toast.LENGTH_LONG).show();
    }
}
