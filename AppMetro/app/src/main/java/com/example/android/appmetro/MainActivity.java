package com.example.android.appmetro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.appmetro.Database.Database_Initializer;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button english ;
    private Button arabic ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        english = (Button) findViewById(R.id.english_btn) ;
        arabic  = (Button) findViewById(R.id.arabic_btn) ;

        english.setOnClickListener(this);
        arabic.setOnClickListener(this);

        //Database_Initializer database_initializer = new Database_Initializer(this) ;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this , StartActivity.class ) ;
        if( view.getId() == R.id.english_btn )
            i.putExtra("appLanguage" , 1 ) ;
        else
            i.putExtra("appLanguage" , 0) ;
        startActivity(i) ;
    }
}
