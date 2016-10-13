package com.example.matilda.tddd13lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // textView = (TextView) findViewById(R.id.textView);
        InteractiveSearcher searchView = new InteractiveSearcher(this);
             searchView.findViewById(R.id.searchBox);

    }
}
