package com.example.android.appmetro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LinesListActivity extends AppCompatActivity implements View.OnClickListener {

    private int appLanguage ;

    private Button one ;
    private Button two ;
    private Button three ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lines_list);

        Bundle bundle = getIntent().getExtras() ;
        appLanguage = bundle.getInt("appLanguage") ;

        one = (Button) findViewById(R.id.one) ;
        two = (Button) findViewById(R.id.two) ;
        three = (Button) findViewById(R.id.three) ;

        appState();

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
    }

    public void appState()
    {
        if(appLanguage == 0)
        {
            one.setText("الخط الأول");
            two.setText("الخط الثانى");
            three.setText("الخط الثالث");
        }
    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this , ShowLines.class) ;
        if(view.getId() == R.id.one)
        {
            i.putExtra("line" , 1) ;
        }
        else if(view.getId() == R.id.two)
        {
            i.putExtra("line" , 2) ;
        }
        else
            i.putExtra("line" , 3) ;

        i.putExtra("appLanguage" , appLanguage) ;
        startActivity(i);
    }
}
