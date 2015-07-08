package com.alekseiivshin.samples.android.androidanotations.providers;

import com.alekseiivshin.samples.android.androidanotations.MainActivity;
import com.alekseiivshin.samples.android.androidanotations.service.DuckService;
import com.alekseiivshin.samples.android.androidanotations.service.RealDuckService;

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
