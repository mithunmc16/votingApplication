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

        // App Header Name Display
        this.setTitle("COMP2100 Voting App");

        // ANU Logo
        ImageView myImageView = (ImageView) findViewById(R.id.imageView3);
        myImageView.setImageResource(R.drawable.logo);
    }

    // Guest Sign In Button
    public void guestPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), Surveylist.class);
        startActivity(intent);

        // Removing Shared Preference Data for Guest Sign In
        SharedPreferences preferences = getSharedPreferences("PREFS", MODE_PRIVATE);
        preferences.edit().clear().commit();
    }

    // Sign In Button
    public void loginPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }

    // Register Button
    public void registerPressed(View view) {
        Intent intent = new Intent(getApplicationContext(), Register.class);
        startActivity(intent);
    }
}
