package com.example.ecat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_notes1 extends AppCompatActivity {
    EditText edtTxt1,edtTxt2;
    Button btn_add;
    DatabaseReference ref;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes1);
        getSupportActionBar().hide();
        edtTxt1=(EditText)findViewById(R.id.titleee);
        edtTxt2=(EditText)findViewById(R.id.disc);
        btn_add=(Button)findViewById(R.id.button_add);
        model=new Model();
        ref= FirebaseDatabase.getInstance().getReference().child("model");

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=edtTxt1.getText().toString().trim();
                String task=edtTxt2.getText().toString().trim();
                if(TextUtils.isEmpty(title)){
                    edtTxt1.setError("Title Required");

                }
                else if(TextUtils.isEmpty(task)){
                    edtTxt2.setError("Task required");
                }
                else{
                    model.setTitle(title);
                    model.setTask(task);
                    ref.push().setValue(model);
                    Toast.makeText(getApplicationContext(),"Task added!",Toast.LENGTH_LONG).show();
                    edtTxt1.setText("");
                    edtTxt2.setText("");
                    Intent intent= new Intent(add_notes1.this,keep_notes1.class);
                    startActivity(intent);
                }
            }
        });
    }
}