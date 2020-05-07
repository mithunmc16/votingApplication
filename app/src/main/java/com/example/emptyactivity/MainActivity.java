package com.example.emptyactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void choice1Pressed(View view) {
        TextView textView = findViewById(R.id.text);
        textView.setText("Close, but no cigar!");
    }

    public void choice2Pressed(View view) {
        TextView textView = findViewById(R.id.text);
        textView.setText("Duh..");
    }

    public void choice3Pressed(View view) {
        TextView textView = findViewById(R.id.text);
        textView.setText("Python? HA!");
    }
}
