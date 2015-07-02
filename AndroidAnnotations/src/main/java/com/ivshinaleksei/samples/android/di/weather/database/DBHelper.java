package com.ivshinaleksei.samples.android.di.weather.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.androidannotations.annotations.EBean;

/**
 * Created by Aleksei Ivshin
 * on 02.07.2015.
 */
@EBean(scope = EBean.Scope.Singleton)
public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "weatherapp.db";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        WeatherTable.onCreate(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        WeatherTable.onUpgrade(sqLiteDatabase, i, i1);
    }
}
