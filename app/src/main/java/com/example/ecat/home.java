package com.example.ecat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class home extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    ImageButton menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        btn1=(Button)findViewById(R.id.quiz_button);
        btn2=(Button)findViewById(R.id.notes_button);
        btn3=(Button)findViewById(R.id.general_topics);
        btn4=(Button)findViewById(R.id.score_button);
        menu=(ImageButton)findViewById(R.id.menu_logout);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,section.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,keep_notes1.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,important_points.class);
                startActivity(intent);
            }
        });
         menu.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(home.this,logout.class);
                 startActivity(intent);
             }
         });
         btn4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(home.this,score.class);
                 startActivity(intent);
             }
         });

    }
}
