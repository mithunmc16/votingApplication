package com.example.comp2100_6442;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("COMP2100 Voting App");
    }

    String surveyTitle;
    EditText surveyTitleInput;

    public void multipleChoicePressed(View view) {
        Intent intent = new Intent(getApplicationContext(), CreateMultipleChoice.class);
        startActivity(intent);
    }

    public void shortAnswerPressed(View view) {

    }

}
