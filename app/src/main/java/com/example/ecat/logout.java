package com.example.ecat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class logout extends AppCompatActivity {
    TextView home_txt,logout_txt,hello_txt;
    FirebaseAuth fauth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser mUser= fauth.getCurrentUser();
        if(mUser!=null){
            hello_txt.setText(mUser.getEmail());
        }
        else{
            Intent intent= new Intent(logout.this,sign_in.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        getSupportActionBar().hide();
        home_txt=(TextView)findViewById(R.id.home1);
        logout_txt=(TextView)findViewById(R.id.logout);
        hello_txt=(TextView)findViewById(R.id.hello);
        fauth=FirebaseAuth.getInstance();




        home_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(logout.this,home.class);
                startActivity(intent);

            }
        });
        logout_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fauth.signOut();
                finish();
                startActivity(new Intent(logout.this,sign_in.class));
            }
        });

    }



}