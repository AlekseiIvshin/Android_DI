package com.ivshinaleksei.samples.android.di.weather.contentprovider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import com.ivshinaleksei.samples.android.di.weather.database.DBHelper;
import com.ivshinaleksei.samples.android.di.weather.database.WeatherTable;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EProvider;

@EProvider
public class WeatherContentProvider extends ContentProvider {
    private static final int WEATHERS = 0;
    private static final int WEATHER_ID = 1;

    public static final String AUTHORITY = "com.alekseiivshin.android.di.weather.contentprovider";
    public static final String BASE_PATH = "weather";

    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);

    public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/weathers";
    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/weathers";

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, BASE_PATH, WEATHERS);
        URI_MATCHER.addURI(AUTHORITY, BASE_PATH + "/#", WEATHER_ID);
    }

    @Bean(DBHelper.class)
    SQLiteOpenHelper mSqLiteOpenHelper;

    public WeatherContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int uriType = URI_MATCHER.match(uri);

        SQLiteDatabase db = mSqLiteOpenHelper.getWritableDatabase();
        int rowsDeleted = 0;
        switch (uriType) {
            case WEATHERS:
                rowsDeleted = db.delete(WeatherTable.TABLE_NAME,selection,selectionArgs);
                break;
            case WEATHER_ID:
                String id = uri.getLastPathSegment();
                if(TextUtils.isEmpty(selection)) {
                    rowsDeleted = db.delete(WeatherTable.TABLE_NAME, WeatherTable.COLUMN_ID + "=" + id, null);
                } else {
                    rowsDeleted = db.delete(WeatherTable.TABLE_NAME, WeatherTable.COLUMN_ID + "=" + id + " and " + selection, selectionArgs);
                }
                break;
        }

        getContext().getContentResolver().notifyChange(uri,null);
        return rowsDeleted;
    }

    @Override
    public String getType(Uri uri) {
        int uriType = URI_MATCHER.match(uri);
        switch (uriType) {
            case WEATHERS:
                return CONTENT_TYPE;
            case WEATHER_ID:
                return CONTENT_ITEM_TYPE;
            default:
                return null;
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = URI_MATCHER.match(uri);

        SQLiteDatabase db = mSqLiteOpenHelper.getWritableDatabase();
        long id = 0;
        switch (uriType) {
            case WEATHER_ID:
                id = db.insert(WeatherTable.TABLE_NAME, null, values);
                break;
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(BASE_PATH + "/" + id);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        queryBuilder.setTables(WeatherTable.TABLE_NAME);

        int uriType = URI_MATCHER.match(uri);
        switch (uriType) {
            case WEATHERS:
                break;
            case WEATHER_ID:
                queryBuilder.appendWhere(WeatherTable.COLUMN_ID + "=" + uri.getLastPathSegment());
                break;
        }

        SQLiteDatabase db = mSqLiteOpenHelper.getWritableDatabase();
        Cursor cursor = queryBuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder);

        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int uriType = URI_MATCHER.match(uri);

        SQLiteDatabase db = mSqLiteOpenHelper.getWritableDatabase();
        int rowsUpdated = 0;
        switch (uriType) {
            case WEATHERS:
                rowsUpdated = db.update(WeatherTable.TABLE_NAME,values,selection,selectionArgs);
                break;
            case WEATHER_ID:
                String id = uri.getLastPathSegment();
                if(TextUtils.isEmpty(selection)) {
                    rowsUpdated = db.update(WeatherTable.TABLE_NAME, values,WeatherTable.COLUMN_ID + "=" + id, null);
                } else {
                    rowsUpdated = db.update(WeatherTable.TABLE_NAME,values, WeatherTable.COLUMN_ID + "=" + id + " and " + selection, selectionArgs);
                }
                break;
        }

        getContext().getContentResolver().notifyChange(uri,null);
        return rowsUpdated;
    }
}
