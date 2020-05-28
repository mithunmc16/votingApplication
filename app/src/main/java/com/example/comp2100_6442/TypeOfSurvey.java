package com.example.comp2100_6442;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TypeOfSurvey extends AppCompatActivity {
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_of_survey);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Types");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView  = findViewById(R.id.rview);
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        layoutmanager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutmanager);
        List<TypeModel> list = new ArrayList<>();
        list.add(new TypeModel("", "MCQ"));
        list.add(new TypeModel("", "MCQ"));
        list.add(new TypeModel("", "MCQ"));

    CategoryAdapter adapter = new CategoryAdapter(list);
    recyclerView.setAdapter(adapter);
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
