package com.example.ecat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class score extends AppCompatActivity {
    ImageButton back_btn;
    TextView txt_score;
    int s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        getSupportActionBar().hide();
        back_btn=(ImageButton)findViewById(R.id.backButton4);
        txt_score=(TextView)findViewById(R.id.scoring);
        s=getIntent().getIntExtra("score",5);
        if(s>5&&s<=11){
            txt_score.setText("Comgratulations!! you have scored "+s);
        }
        else{
            txt_score.setText("oh no! better luck next time, you have scored "+s);
        }

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(score.this,home.class);
                startActivity(intent);
            }
        });

    }
}