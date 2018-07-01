package com.example.android.appmetro.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.appmetro.Station;

import java.util.ArrayList;

public class DbModel {

    private  MetroDbHelper metroDbHelper ;
    private Context context ;

    public DbModel(Context newContext)
    {
        context = newContext ;
        metroDbHelper = new MetroDbHelper(context) ;
    }

    public void addStationToFirstLine (Station station)
    {
        SQLiteDatabase db = metroDbHelper.getWritableDatabase() ;

        ContentValues contentValues = new ContentValues() ;

        contentValues.put(Contract.firstLine._ID , station.getId());
        contentValues.put(Contract.firstLine.STATION_ARABIC_NAME , station.getArabicName() );
        contentValues.put(Contract.firstLine.STATION_ENGLISH_NAME, station.getEnglishName());
        contentValues.put(Contract.firstLine.STATION_STATE, station.getState() );
        contentValues.put(Contract.firstLine.LINE_NUMBER , station.getLineNumber());

        db.insert(Contract.firstLine.TABLE_NAME , null , contentValues) ;

    }

    public void addStationToSecondLine (Station station)
    {
        SQLiteDatabase db = metroDbHelper.getWritableDatabase() ;

        ContentValues contentValues = new ContentValues() ;

        contentValues.put(Contract.secondLine._ID , station.getId());
        contentValues.put(Contract.secondLine.STATION_ARABIC_NAME , station.getArabicName() );
        contentValues.put(Contract.secondLine.STATION_ENGLISH_NAME , station.getEnglishName() );
        contentValues.put(Contract.secondLine.STATION_STATE, station.getState() );
        contentValues.put(Contract.secondLine.LINE_NUMBER , station.getLineNumber());

        db.insert(Contract.secondLine.TABLE_NAME , null , contentValues) ;
    }

    public void addStationToThirdLine (Station station)
    {
        SQLiteDatabase db = metroDbHelper.getWritableDatabase() ;

        ContentValues contentValues = new ContentValues() ;

        contentValues.put(Contract.thirdLine._ID , station.getId());
        contentValues.put(Contract.thirdLine.STATION_ARABIC_NAME , station.getArabicName() );
        contentValues.put(Contract.thirdLine.STATION_ENGLISH_NAME , station.getEnglishName() );
        contentValues.put(Contract.thirdLine.STATION_STATE, station.getState() );
        contentValues.put(Contract.thirdLine.LINE_NUMBER , station.getLineNumber());

        db.insert(Contract.thirdLine.TABLE_NAME , null , contentValues) ;
    }

    public ArrayList<Station> getFirstLine()
    {
        SQLiteDatabase db = metroDbHelper.getReadableDatabase() ;
        ArrayList<Station> stations = new ArrayList<>() ;

        Cursor cursor = db.rawQuery("SELECT * FROM " + Contract.firstLine.TABLE_NAME , null) ;

        try{
            while(cursor.moveToNext())
            {
               stations.add( new Station(cursor.getString( cursor.getColumnIndex(Contract.firstLine.STATION_ARABIC_NAME) ) ,
                            cursor.getString(cursor.getColumnIndex(Contract.firstLine.STATION_ENGLISH_NAME))  ,
                            cursor.getInt( cursor.getColumnIndex(Contract.firstLine._ID)) ,
                            cursor.getInt( cursor.getColumnIndex( Contract.firstLine.STATION_STATE)) ,
                            cursor.getInt(cursor.getColumnIndex(Contract.firstLine.LINE_NUMBER))
                        ) ) ;
            }
        }
        finally {
            cursor.close();
        }
        return stations ;
    }

    public ArrayList<Station> getSecondLine()
    {
        SQLiteDatabase db = metroDbHelper.getReadableDatabase() ;
        ArrayList<Station> stations = new ArrayList<>() ;

        Cursor cursor = db.rawQuery("SELECT * FROM " + Contract.secondLine.TABLE_NAME , null) ;

        try{
            while (cursor.moveToNext())
            {
                stations.add( new Station(cursor.getString( cursor.getColumnIndex(Contract.secondLine.STATION_ARABIC_NAME) ) ,
                        cursor.getString(cursor.getColumnIndex(Contract.secondLine.STATION_ENGLISH_NAME))  ,
                        cursor.getInt( cursor.getColumnIndex(Contract.secondLine._ID)) ,
                        cursor.getInt( cursor.getColumnIndex( Contract.secondLine.STATION_STATE)) ,
                        cursor.getInt(cursor.getColumnIndex(Contract.secondLine.LINE_NUMBER))
                ) ) ;
            }

        }
        finally {
            cursor.close();
        }
        return stations ;
    }

    public ArrayList<Station> getThirdLine()
    {
        SQLiteDatabase db = metroDbHelper.getReadableDatabase() ;
        ArrayList<Station> stations = new ArrayList<>() ;

        Cursor cursor = db.rawQuery("SELECT * FROM " + Contract.thirdLine.TABLE_NAME , null) ;

        try{
            while (cursor.moveToNext())
            {
                stations.add( new Station(cursor.getString( cursor.getColumnIndex(Contract.thirdLine.STATION_ARABIC_NAME) ) ,
                        cursor.getString(cursor.getColumnIndex(Contract.thirdLine.STATION_ENGLISH_NAME))  ,
                        cursor.getInt( cursor.getColumnIndex(Contract.thirdLine._ID)) ,
                        cursor.getInt( cursor.getColumnIndex( Contract.thirdLine.STATION_STATE)) ,
                        cursor.getInt(cursor.getColumnIndex(Contract.thirdLine.LINE_NUMBER))
                ) ) ;
            }
        }
        finally {
            cursor.close();
        }
        return stations ;
    }

}
