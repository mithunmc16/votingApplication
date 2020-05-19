package com.example.comp2100_6442;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class CreateSurvey extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_survey);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout);

        for(int i = 0; i<5; i++){
            EditText editText = new EditText(this);
            editText.setText(String.valueOf(i));
            linearLayout.addView(editText);

        }


    }


}
