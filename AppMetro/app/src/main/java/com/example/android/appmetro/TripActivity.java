package com.example.android.appmetro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TripActivity extends AppCompatActivity {

    private int appLanguage ;

    private TextView price ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        Bundle bundle = getIntent().getExtras() ;
        String from = bundle.getString("from") ;
        String to = bundle.getString("to") ;
        appLanguage =  bundle. getInt("appLanguage") ;

        RoadTrip roadTrip = new RoadTrip(this , appLanguage) ;
        ArrayList<String> result = roadTrip.start(from , to) ;

        int x = result.size() ;
        if(x < 9) x = 3 ;
        else if(x < 16) x = 5 ;
        else x = 7 ;

        price = (TextView) findViewById(R.id.trip_price) ;
        if(appLanguage == 0)
        {
            price.setText("سعر التذكرة "+ x + " جنيه " );
            price.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START); ;
        }
        else
            price.setText("Ticket Price = " + x + " L.E ");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this ,android.R.layout.simple_list_item_1 , result ) ;
        ListView listView = (ListView) findViewById(R.id.list) ;
        listView.setAdapter(arrayAdapter);
    }
}
