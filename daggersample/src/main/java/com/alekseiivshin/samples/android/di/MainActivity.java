package com.alekseiivshin.samples.android.di;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.alekseiivshin.samples.android.di.daggersample.R;
import com.alekseiivshin.samples.android.di.service.DuckService;

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
