package com.example.ecat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class sign_in extends AppCompatActivity {
    TextView singIn_action;
    Button btn;
    FirebaseAuth fauth;
    ProgressBar pB;
    EditText edt_email;
    EditText edt_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
        singIn_action = (TextView) findViewById(R.id.signup_text);
        btn = (Button) findViewById(R.id.signin);
        edt_email = (EditText) findViewById(R.id.txt_email);
        edt_pass = (EditText) findViewById(R.id.txt_pass);
        pB = (ProgressBar) findViewById(R.id.progressBar);
        fauth = FirebaseAuth.getInstance();

        singIn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sign_in.this, signup.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInActivity();
            }
        });
    }

    public void signInActivity() {
        String email = edt_email.getText().toString();
        String pass = edt_pass.getText().toString();
        //validation for text fields
        if (TextUtils.isEmpty(email)) {
            edt_email.setError("Email is required");
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            edt_pass.setError("Password is required");
            return;
        }
        pB.setVisibility(View.VISIBLE);

        fauth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                    pB.setVisibility(View.GONE);

                    Intent intent = new Intent(sign_in.this, home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Login failed! Please try again later", Toast.LENGTH_LONG).show();
                    pB.setVisibility(View.INVISIBLE);
                    edt_email.setText("");
                    edt_pass.setText("");
                }
            }
        });

    }

}
