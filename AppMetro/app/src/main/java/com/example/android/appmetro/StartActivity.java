package com.example.android.appmetro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.appmetro.Database.Database_Initializer;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private int appLanguage ;

    // design views
    private TextView fromTextView ;
    private TextView toTextView ;
    private EditText from ;
    private EditText to;
    private Button go ;
    private Button lines ;
    private Button prices ;
    private Button map ;
    private Spinner fromSpinner;
    private Spinner toSpinner ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Bundle bundle = getIntent().getExtras() ;
        appLanguage = bundle.getInt("appLanguage") ;

        fromTextView = (TextView) findViewById(R.id.from_textview) ;
        toTextView = (TextView) findViewById(R.id.to_textview ) ;

        from = (EditText) findViewById(R.id.from) ;
        to = (EditText) findViewById(R.id.to) ;

        go = (Button) findViewById(R.id.go) ;
        go.setOnClickListener(this);

        lines = (Button) findViewById(R.id.lines) ;
        lines.setOnClickListener(this);

        prices = (Button) findViewById(R.id.prices) ;
        prices.setOnClickListener(this);

        map = (Button) findViewById(R.id.map) ;

        fromSpinner = (Spinner) findViewById(R.id.fromspinner) ;
        toSpinner = (Spinner) findViewById(R.id.tospinner) ;

        appState();

        Database_Initializer database_initializer = new Database_Initializer(this) ;
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this ,
                android.R.layout.simple_spinner_dropdown_item ,
                database_initializer.getLineNames(appLanguage) ) ;

        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fromSpinner.setAdapter(stringArrayAdapter);
        toSpinner.setAdapter(stringArrayAdapter);

        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                from.setText( adapterView.getItemAtPosition(i).toString() );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                to.setText(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void appState()
    {
        if(appLanguage == 0)
        {
            fromTextView.setText(": البداية");
            toTextView.setText(": النهاية");
            go.setText("ابحث");
            lines.setText("الخطوط");
            prices.setText("الأسعار");
            map.setText("الخريطة");
        }
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.go)
        {
            String fromText = from.getText().toString() ;
            String toText   = to.getText().toString() ;

            Intent i = new Intent(this , TripActivity.class) ;
            if( (fromText != null && toText != null) ||  fromText.equals(" ") && toText.equals(" ") )
            {
                i.putExtra("from" , fromText) ;
                i.putExtra("to" , toText) ;
                i.putExtra("appLanguage" , appLanguage) ;
                startActivity(i);
            }
            else
                Toast.makeText(this , "Please Enter Correct values" , Toast.LENGTH_LONG).show() ;
        }
        else if (view.getId() == R.id.lines)
        {
            Intent i = new Intent(this , LinesListActivity.class ) ;
            i.putExtra("appLanguage" , appLanguage) ;
            startActivity(i);
        }
        else if(view.getId() == R.id.prices)
        {
            Toast.makeText(this , "prices buttons" , Toast.LENGTH_LONG).show();
        }

    }
}
