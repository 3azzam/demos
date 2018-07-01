package com.example.android.appmetro;

public class Station {

    private int id ;
    private String arabicName ;
    private String englishName ;
    private int state ;
    private int lineNumber ;


    public Station()
    {
        id = 0 ;
        arabicName = "" ;
        englishName = "" ;
        state = 0 ;
        lineNumber = 0 ;
    }


    public Station(String arabicName , String englishName , int id , int state , int lineNumber )
    {
        this.arabicName = arabicName ;
        this.englishName = englishName ;
        this.id = id ;
        this.state = state ;
        this.lineNumber = lineNumber ;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
