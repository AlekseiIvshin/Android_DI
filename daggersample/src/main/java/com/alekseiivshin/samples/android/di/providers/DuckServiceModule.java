package com.alekseiivshin.samples.android.di.providers;

import com.alekseiivshin.samples.android.di.DaggerSampleApp;
import com.alekseiivshin.samples.android.di.MainActivity;
import com.alekseiivshin.samples.android.di.service.DuckService;
import com.alekseiivshin.samples.android.di.service.RealDuckService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aleksei Ivshin
 * on 07.07.2015.
 */
@Module(injects = MainActivity.class)
public class DuckServiceModule {

    @Provides
    DuckService provideDuckService(){
        return new RealDuckService();
    }
}
