package com.example.comp2100_6442;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartSurvey extends AppCompatActivity {
    private Button StartBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_survey);
        StartBtn = findViewById(R.id.start_btn);
        StartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent typeOfSurvey = new Intent(getApplicationContext(), TypeOfSurvey.class);
                startActivity(typeOfSurvey);
            }
        });



    }

}
