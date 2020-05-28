package com.example.comp2100_6442;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("COMP2100 Voting App");

        ImageView myImageView = (ImageView) findViewById(R.id.imageView3);
        myImageView.setImageResource(R.drawable.logo);
    }

    public void guestPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), StartSurvey.class);
        startActivity(intent);

        SharedPreferences preferences = getSharedPreferences("PREFS", MODE_PRIVATE);
        preferences.edit().clear().commit();
    }

    public void loginPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }

    public void registerPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), Register.class);
        startActivity(intent);
    }
}
