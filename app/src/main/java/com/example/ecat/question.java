package com.example.ecat;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class question extends AppCompatActivity {
    ImageButton btn_next,back;
    RadioGroup rd;
    RadioButton opt1,opt2,opt3,opt4;
    TextView txt_ques;
    LinearLayout lnr;
    int count=0;
    int i=1;
    //List<QuestionModel> list;
    //int positon=0;
    QuestionModel object= new QuestionModel();
    String answer;
    int score;
    int length= object.quizQustions.length;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        getSupportActionBar().hide();
        btn_next = (ImageButton) findViewById(R.id.button_next);
        back = (ImageButton) findViewById(R.id.backButton1);
        opt1 = (RadioButton) findViewById(R.id.option1);
        opt2 = (RadioButton) findViewById(R.id.option2);
        opt3 = (RadioButton) findViewById(R.id.option3);
        opt4 = (RadioButton) findViewById(R.id.option4);
        rd = (RadioGroup) findViewById(R.id.radio_main);
        txt_ques = (TextView) findViewById(R.id.question_text);
        lnr = (LinearLayout) findViewById(R.id.layout_container);
        random = new Random();
        //list= new ArrayList<>();
        //list.add(new QuestionModel("which is the first planet of the solar system?","jupiter","mars","ploto","murcery","murcery"));
        // list.add(new QuestionModel("which is the Second planet of the solar system?","mars","setran","venus","earth","venus"));
        //list.add(new QuestionModel("question 3","a","b","c","d","c"));
        //list.add(new QuestionModel("question 4","a","b","c","d","b"));
        //list.add(new QuestionModel("question 5","a","b","c","d","c"));
        //list.add(new QuestionModel("question 6","a","b","c","d","a"));
        //list.add(new QuestionModel("question 7","a","b","c","d","a"));
        //list.add(new QuestionModel("question 8","a","b","c","d","d"));
        //list.add(new QuestionModel("question 9","a","b","c","d","c"));
        //list.add(new QuestionModel("question 10","a","b","c","d","a"));
        updateQuiz(random.nextInt(length));
        rd.clearCheck();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = rd.getCheckedRadioButtonId();
                rd.clearCheck();
                if (i < 10) {
                    if (id == -1) {
                        Toast.makeText(getApplicationContext(), "Please select one option", Toast.LENGTH_LONG).show();
                    } else if (id == opt1.getId() && opt1.getText().equals(answer)) {
                        score++;
                        i=i+1;
                        Toast.makeText(getApplicationContext(), "Score" + score+" "+i, Toast.LENGTH_LONG).show();
                        updateQuiz(random.nextInt(length));

                    } else if (id == opt2.getId() && opt2.getText().equals(answer)) {

                        score++;
                        i=i+1;
                        Toast.makeText(getApplicationContext(), "Score" + score+" "+i, Toast.LENGTH_LONG).show();
                        updateQuiz(random.nextInt(length));


                    } else if (id == opt3.getId() && opt3.getText().equals(answer)) {
                        score++;
                        i=i+1;
                        Toast.makeText(getApplicationContext(), "Score" + score+" "+i, Toast.LENGTH_LONG).show();
                        updateQuiz(random.nextInt(length));


                    } else if (id == opt4.getId() && opt4.getText().equals(answer)) {

                        score++;
                        i=i+1;
                        Toast.makeText(getApplicationContext(), "Score" + score+" "+i, Toast.LENGTH_LONG).show();
                        updateQuiz(random.nextInt(length));
                    } else {
                        i=i+1;  
                        Toast.makeText(getApplicationContext(), "wrong ans"+score+" "+i, Toast.LENGTH_LONG).show();

                        updateQuiz(random.nextInt(length));
                        // Intent intent = new Intent(question.this,home.class);
                        //startActivity(intent);
                    }

                }
                else{
                    Toast.makeText(getApplicationContext(),"quiz end",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(question.this,score.class);
                    intent.putExtra("score",score);
                    startActivity(intent);
                    finish();

                }
            }



            // playAnimation(txt_ques,0,list.get(positon).getQuestion());

        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(question.this,home.class);
                startActivity(intent);
            }
        });
    }






    private void updateQuiz(int num) {
        txt_ques.setText(object.getQuestions(num));
        opt1.setText(object.getOption1(num));
        opt2.setText(object.getOption2(num));
        opt3.setText(object.getOption3(num));
        opt4.setText(object.getOption4(num));
        answer=object.getCorrectAns(num);
    }
//    public void playAnimation(final View view, final int value){
//        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100).setInterpolator(new DecelerateInterpolator())
//                .setListener(new Animator.AnimatorListener() {
//                    @Override
//                    public void onAnimationStart(Animator animation) {
//                       if(value==0 && count < 5){
//                           playAnimation(lnr.getChildAt(count),0);
//                       }
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        // view will visible after data change
//                        if(value==0){
//                            ((TextView)view).setText(data);
//                            playAnimation(view,1,data);
//                        }
//
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animator animation) {
//
//                    }
//                });
//    }
}