package com.example.android.appmetro.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MetroDbHelper extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "metro_lines"  ;
    private static final int DATA_BASE_VERSION  = 1 ;

    public MetroDbHelper(Context context )
    {
        super(context , DATA_BASE_NAME , null , DATA_BASE_VERSION ) ;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String Create_firstLine_TABLE =  "CREATE TABLE " + Contract.firstLine.TABLE_NAME + " ( "
                + Contract.firstLine._ID + " INTEGER PRIMARY KEY , "
                + Contract.firstLine.STATION_ARABIC_NAME + " TEXT , "
                + Contract.firstLine.STATION_ENGLISH_NAME + " TEXT , "
                + Contract.firstLine.STATION_STATE + " INTEGER NOT NULL , "
                + Contract.firstLine.LINE_NUMBER + " INTEGER NOT NULL ) ; ";

        String Create_secondLine_TABLE =  "CREATE TABLE " + Contract.secondLine.TABLE_NAME + " ( "
                + Contract.secondLine._ID + " INTEGER PRIMARY KEY , "
                + Contract.secondLine.STATION_ARABIC_NAME + " TEXT , "
                + Contract.secondLine.STATION_ENGLISH_NAME + " TEXT , "
                + Contract.secondLine.STATION_STATE + " INTEGER NOT NULL ,"
                + Contract.secondLine.LINE_NUMBER + " INTEGER NOT NULL ) ; ";

        String Create_thirdLine_TABLE =  "CREATE TABLE " + Contract.thirdLine.TABLE_NAME + " ( "
                + Contract.thirdLine._ID + " INTEGER PRIMARY KEY , "
                + Contract.thirdLine.STATION_ARABIC_NAME + " TEXT , "
                + Contract.thirdLine.STATION_ENGLISH_NAME + " TEXT , "
                + Contract.thirdLine.STATION_STATE + " INTEGER NOT NULL , "
                + Contract.firstLine.LINE_NUMBER + " INTEGER NOT NULL ) ; ";


        sqLiteDatabase.execSQL(Create_firstLine_TABLE) ;
        sqLiteDatabase.execSQL(Create_secondLine_TABLE);
        sqLiteDatabase.execSQL(Create_thirdLine_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATA_BASE_NAME );
        onCreate(sqLiteDatabase);
    }
}
