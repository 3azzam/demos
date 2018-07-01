package com.example.android.appmetro;


import android.content.Context;

import com.example.android.appmetro.Database.Database_Initializer;
import com.example.android.appmetro.Database.DbModel;

import java.util.ArrayList;

public class RoadTrip {

    private ArrayList<Station> firstLine ;
    private ArrayList<Station> secondLine ;
    private ArrayList<Station> thirdLine ;

    private int appLanguge ;
    private Station global  ;  // to store transition station between different lines

    public RoadTrip(Context context , int language )
    {
        Database_Initializer database_Initializer = new Database_Initializer(context) ;
        global = new Station() ;

        DbModel dbModel = new DbModel(context) ;

        firstLine = database_Initializer.getFirstLine() ;
        secondLine = database_Initializer.getSecondLine() ;
        thirdLine = database_Initializer.getThirdLine() ;

        /*firstLine = dbModel.getFirstLine() ;
        secondLine = dbModel.getSecondLine() ;
        thirdLine = dbModel.getThirdLine() ;*/

        appLanguge = language ;
    }

    public Station getStation(String name)
    {
        for(int i = 0 ; i < firstLine.size() ; i++ )
            if( firstLine.get(i).getArabicName().equals(name) || firstLine.get(i).getEnglishName().equals(name)  ) return firstLine.get(i) ;

        for(int i = 0 ; i < secondLine.size() ; i++ )
            if( secondLine.get(i).getArabicName().equals(name) || secondLine.get(i).getEnglishName().equals(name)  ) return secondLine.get(i) ;

        for(int i = 0 ; i < thirdLine.size() ; i++ )
            if( thirdLine.get(i).getArabicName().equals(name) || thirdLine.get(i).getEnglishName().equals(name)  ) return thirdLine.get(i) ;

        return null ;
    }

    public ArrayList<String> start(String a , String b)
    {
        Station begin = getStation(a) ;
        Station end = getStation(b) ;

        int factor = 0 ;
        if(begin.getLineNumber() > end.getLineNumber()) factor = -1 ;
        else factor = 1 ;

        return road(begin, end , factor ) ;
    }

    public ArrayList<String> road(Station begin , Station end , int factor)
    {
        ArrayList<String> arr = new ArrayList<>() ;

        global = begin ;
        for(int i = begin.getLineNumber() ; i != end.getLineNumber() ; i+=factor )
        {
            arr.addAll(transitionIsNotEqual( global, i+factor)) ;
        }
        arr.addAll(transitionIsEqual(global, end)) ;

        if(appLanguge == 0) arr.add(end.getArabicName()) ;
        else arr.add(end.getEnglishName()) ;
        return arr ;
    }

    public Station stationAtLine(int nextLine , Station st)
    {

        if(nextLine == 1)
        {
            for(int i = 0 ; i < firstLine.size() ; i++ )
                if(firstLine.get(i).getArabicName().equals( st.getArabicName()) )
                    return firstLine.get(i) ;
        }
        else if(nextLine == 2)
        {
            for(int i = 0 ; i < secondLine.size() ; i++ )
                if(secondLine.get(i).getArabicName()== st.getArabicName()) return secondLine.get(i) ;
        }
        else
        {
            for(int i = 0 ; i < thirdLine.size() ; i++ )
                if(thirdLine.get(i).getArabicName()== st.getArabicName()) return thirdLine.get(i) ;
        }
        return firstLine.get(0) ;
    }

    public Station nextTransition(Station st , int nextLine)
    {
        ArrayList<Station> arr  ;
        if(st.getLineNumber() == 1) arr = firstLine ;
        else if( st.getLineNumber() == 2) arr = secondLine ;
        else arr = thirdLine ;

        int idx = 0 ;
        for(int i = 0 ; i < arr.size() ; i++)
        {
            Station temp = arr.get(i) ;
            if( temp.getId() != st.getId() && temp.getState() == nextLine )
            {
                idx = i ;
                if(idx > st.getId() ) break;
            }
        }
        return arr.get(idx) ;
    }

    public ArrayList<String> transitionIsNotEqual(Station begin , int nextLine )
    {
        ArrayList<String> arr = new ArrayList<>() ;

        Station next =  nextTransition(begin, nextLine) ;
        global = stationAtLine(nextLine, next) ;

        arr.addAll( transitionIsEqual(begin, next) ) ;
        return arr ;
    }

    public ArrayList<String> transitionIsEqual(Station begin , Station end)
    {
        ArrayList<String> ans = new ArrayList<>() ;

        int factor = 1 ;
        if(begin.getId() > end.getId() ) factor = -1 ;

        String arabic = ""  ;
        String english = "" ;

        for(int i = begin.getId() ; i != end.getId() ; i+=factor)
        {
            if(begin.getLineNumber() == 1)
            {
                arabic = firstLine.get(i).getArabicName() ;
                english = firstLine.get(i).getEnglishName() ;
            }
            else if(begin.getLineNumber() == 2)
            {
                arabic = secondLine.get(i).getArabicName() ;
                english = secondLine.get(i).getEnglishName() ;
            }
            else
            {
                arabic = thirdLine.get(i).getArabicName() ;
                english = thirdLine.get(i).getEnglishName() ;
            }
            if(appLanguge == 0) ans.add(arabic) ;
            else ans.add(english) ;
        }
        return ans ;
    }
}
