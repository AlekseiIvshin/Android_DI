package com.alekseiivshin.samples.android.androidanotations.service;

/**
 * Created by Aleksei Ivshin
 * on 07.07.2015.
 */
public class RealDuckService implements DuckService {

    @Override
    public int getHealthPoints() {
        return 100;
    }

    @Override
    public String getDuckName() {
        return "Real duck";
    }
}
