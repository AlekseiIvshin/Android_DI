package com.alekseiivshin.samples.android.dagger.providers;

import com.alekseiivshin.samples.android.dagger.MainActivity;
import com.alekseiivshin.samples.android.dagger.service.DuckService;
import com.alekseiivshin.samples.android.dagger.service.RealDuckService;

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
