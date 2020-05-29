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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TypeOfSurvey extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

private RecyclerView recyclerView;
private List<TypeModel> list;
   protected  void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_type_of_survey);
       Toolbar toolbar = findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
       getSupportActionBar().setTitle("Categories");

       recyclerView = findViewById(R.id.rview);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
       layoutManager.setOrientation(RecyclerView.VERTICAL);
       recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();



       final CategoryAdapter adapter = new CategoryAdapter(list);
       recyclerView.setAdapter(adapter);

       myRef.child("Types").addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                  list.add(dataSnapshot1.getValue(TypeModel.class));
              }
              adapter.notifyDataSetChanged();
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {
               Toast.makeText(TypeOfSurvey.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });
   }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if(item.getItemId()== android.R.id.home){
           finish();
       }
        return super.onOptionsItemSelected(item);
    }
}
