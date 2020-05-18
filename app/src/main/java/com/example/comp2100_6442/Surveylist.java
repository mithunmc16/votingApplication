package com.example.comp2100_6442;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Surveylist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveylist);
        this.setTitle("Survey List");

        SharedPreferences preferences = getSharedPreferences("PREFS", MODE_PRIVATE);
        String show = preferences.getString("show", "");

        TextView display = (TextView) findViewById(R.id.successView);
        display.setText(show);
    }
}
