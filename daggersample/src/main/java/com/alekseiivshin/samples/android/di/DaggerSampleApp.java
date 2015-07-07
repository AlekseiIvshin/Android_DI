package com.alekseiivshin.samples.android.di;

import android.app.Application;

import com.alekseiivshin.samples.android.di.providers.DuckServiceModule;

import dagger.ObjectGraph;

/**
 * Created by Aleksei Ivshin
 * on 07.07.2015.
 */
public class DaggerSampleApp extends Application {

    private static ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        mObjectGraph = ObjectGraph.create(new DuckServiceModule());
    }

    public static ObjectGraph getObjectGraph(){
        return mObjectGraph;
    }
}
