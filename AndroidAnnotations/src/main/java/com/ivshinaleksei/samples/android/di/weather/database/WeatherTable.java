package com.ivshinaleksei.samples.android.di.weather.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Aleksei Ivshin
 * on 02.07.2015.
 */
public class WeatherTable {

    public static final String TABLE_NAME = "weather";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TEMPERATURE = "temperature";
    public static final String COLUMN_PRESSURE = "pressure";
    public static final String COLUMN_HUMIDITY = "humidity";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private static final String CREATE_TABLE =
            "create table " + TABLE_NAME + "(" +
                    COLUMN_ID + " integer primary key," +
                    COLUMN_TEMPERATURE + " integer, " +
                    COLUMN_PRESSURE + " integer, " +
                    COLUMN_HUMIDITY + " integer, " +
                    COLUMN_TYPE + " text, " +
                    COLUMN_CITY + " text, " +
                    COLUMN_TIMESTAMP + " integer)";
    private static final String DROP_TABLE = "drop table if exists " + TABLE_NAME;

    public static void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    public static void onUpgrade(SQLiteDatabase sqLiteDatabase, int fromVersion, int toVersion) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }


}
