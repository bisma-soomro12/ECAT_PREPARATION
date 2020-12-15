package com.example.ecat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    EditText txtName,txtEmail,txtPass;
    Button btn_singUp;
    ProgressBar pB;
    FirebaseAuth fauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        txtName=(EditText)findViewById(R.id.txt_name);
        txtEmail=(EditText)findViewById(R.id.txt_email);
        txtPass=(EditText)findViewById(R.id.txt_pass);
        btn_singUp=(Button)findViewById(R.id.signup);
        pB=(ProgressBar)findViewById(R.id.progressBar);
        fauth=FirebaseAuth.getInstance();


        btn_singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=txtName.getText().toString();
                String email=txtEmail.getText().toString();
                String pass=txtPass.getText().toString();
                // validation for text fields
                if(TextUtils.isEmpty(name)){
                    txtName.setError("User Name is required");
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    txtEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    txtEmail.setError("Password is required");
                    return;
                }
                if(pass.length()<6){
                    txtPass.setError("password to short");
                    return;
                }
                pB.setVisibility(View.VISIBLE);


                // register the user in firebase!
                fauth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(signup.this,new OnCompleteListener<AuthResult>() {
                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {

                   if(task.isSuccessful()){
                       Toast.makeText(signup.this, "user created", Toast.LENGTH_SHORT).show();
                       Intent intent=new Intent(signup.this,home.class);
                       startActivity(intent);
                       finish();
                   }
                   else{
                       Toast.makeText(signup.this,"Error!"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                   }
                    }
                });
            }
        });


    }
}
