package com.example.comp2100_6442;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Surveylist extends AppCompatActivity {
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveylist);
        this.setTitle("Survey List");
        rb1 = findViewById(R.id.MCQ);
        rb2 = findViewById(R.id.Subjective);
        rb3 = findViewById(R.id.CreateYourOwn);

        SharedPreferences preferences = getSharedPreferences("PREFS", MODE_PRIVATE);
        String show = preferences.getString("show", "");

        TextView display = (TextView) findViewById(R.id.successView);
        display.setText(show);

    }
    public void NextPressed(View view) {
        if( rb1.isChecked()) {
            Intent intent = new Intent(getApplicationContext(), CreateSurvey.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);

        }
        SharedPreferences preferences = getSharedPreferences("PREFS", MODE_PRIVATE);
        preferences.edit().clear().commit();
    }
}
