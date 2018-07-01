package com.example.android.appmetro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.appmetro.Database.DbModel;

import java.util.ArrayList;

public class ShowLines extends AppCompatActivity {

    private int appLanguage ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_lines);

        Bundle bundle = getIntent().getExtras();
        int temp = bundle.getInt("line") ;
        appLanguage = bundle.getInt("appLanguage") ;


        DbModel dbModel = new DbModel(this) ;
        ArrayList<Station> arr = new ArrayList<>() ;

        if(temp == 1)
            arr = dbModel.getFirstLine() ;
        else if(temp == 2)
            arr = dbModel.getSecondLine() ;
        else
            arr = dbModel.getThirdLine() ;

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0 ; i < arr.size() ; i++)
        {
            if(appLanguage == 0)
                list.add(arr.get(i).getArabicName()) ;
            else
                list.add(arr.get(i).getEnglishName()) ;
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this ,android.R.layout.simple_list_item_1,list) ;
        ListView listView = (ListView) findViewById(R.id.showlines);
        listView.setAdapter(arrayAdapter);

    }
}
