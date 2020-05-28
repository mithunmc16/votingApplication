package com.example.comp2100_6442;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity {

    private TextView question,noIndicator;
    private LinearLayout optionsContainer;
    private Button shareBtn, nextBtn;
    private int count = 0;
    private List<SurveyQuestionModel> list;
    private int pos = 0;
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

        list = new ArrayList<>();
        list.add(new SurveyQuestionModel("question1","option A", "Option B", "Option C", "Option D" ));
        list.add(new SurveyQuestionModel("question2","option A", "Option A", "Option A", "Option A" ));
        list.add(new SurveyQuestionModel("question3","option C", "Option C", "Option C", "Option C" ));
        list.add(new SurveyQuestionModel("question4","option D", "Option D", "Option D", "Option D" ));
        list.add(new SurveyQuestionModel("question5","option D", "Option B", "Option C", "Option A" ));

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
                    return;
                }
                count = 0;
                playAnimation(question,0,list.get(pos).getQuestion());
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
