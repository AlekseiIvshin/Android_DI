package com.alekseiivshin.samples.android.androidanotations;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.alekseiivshin.samples.android.androidanotations.daggersample.R;
import com.alekseiivshin.samples.android.androidanotations.service.DuckService;

import javax.inject.Inject;

public class MainActivity extends Activity {

    @Inject
    DuckService duckService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(DaggerSampleApp.getObjectGraph()!=null){
            DaggerSampleApp.getObjectGraph().inject(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Duck: name = "+duckService.getDuckName()+"; hp = "+duckService.getHealthPoints()+";",Toast.LENGTH_LONG).show();
    }
}
