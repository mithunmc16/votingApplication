package com.example.comp2100_6442;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    private TextView question,noIndicator;
    private LinearLayout optionsContainer;
    private Button shareBtn, nextBtn;
    private int count = 0;
    private List<SurveyQuestionModel> list;
    private int pos = 0;
    private String category;
    private int setNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        question = findViewById(R.id.question);
        noIndicator = findViewById(R.id.no_indicator);
        optionsContainer = findViewById(R.id.options_container);
        shareBtn = findViewById(R.id.sharebtn);
        nextBtn = findViewById(R.id.nextbtn);
        category = getIntent().getStringExtra("category");
        setNo = getIntent().getIntExtra("setno",1);


        for(int i = 0; i<4; i++){
            optionsContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkoption(((Button)v));
                }
            });
        }
        list = new ArrayList<>();
        myRef.child("SETS").child(category).child("questions").orderByChild("Setno").equalTo(setNo).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    list.add(snapshot.getValue(SurveyQuestionModel.class));
                }
                if(list.size()>0){

                    for(int i = 0; i<4; i++){
                        optionsContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkoption(((Button)v));
                            }
                        });

                    }
                    playAnimation(question, 0, list.get(pos).getQuestion());
                    nextBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            nextBtn.setEnabled(false);
                            nextBtn.setAlpha(0.6f);
                            enableoption(true);
                            pos++;
                            if(pos == list.size()){
                                Intent finalq = new Intent(QuestionsActivity.this, EndPage.class);
                                startActivity(finalq);
                                return;
                            }
                            count = 0;
                            playAnimation(question,0,list.get(pos).getQuestion());
                        }
                    });
                }
                else{
                    finish();
                    Toast.makeText(QuestionsActivity.this, "no questions", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(QuestionsActivity.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
        });



    }
    private void playAnimation(final View view, final int value, final String data){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if(value==0 && count<4){
                    String option ="";
                    if(count == 0) {
                        option = list.get(pos).getOptionA();

                    }else if(count == 1){
                        option = list.get(pos).getOptionB();
                    }else if(count == 2){
                        option = list.get(pos).getOptionC();
                    }
                    else if(count == 3){
                        option = list.get(pos).getOptionD();
                    }
                    playAnimation(optionsContainer.getChildAt(count),0, option );
                    count++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {


                if(value == 0){
                    try{
                        ((TextView)view).setText(data);
                        noIndicator.setText(pos+1+"/"+list.size());
                    }catch (Exception e){
                        ((Button)view).setText(data);
                    }
                    playAnimation(view,1, data);

                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    private void checkoption(Button selectedoption){

        enableoption(false);
        nextBtn.setEnabled(true);
        nextBtn.setAlpha(1);
        selectedoption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF5C")));
    }
    private void enableoption(boolean enable) {
        for (int i = 0; i < 4; i++) {
            optionsContainer.getChildAt(i).setEnabled(enable);
            if(enable == true){
                optionsContainer.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));


            }

        }
    }
}
