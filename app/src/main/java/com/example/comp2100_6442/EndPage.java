package com.example.comp2100_6442;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EndPage extends AppCompatActivity {
private Button doneBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page);
        doneBtn = findViewById(R.id.done);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
