package com.example.ecat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_notes extends AppCompatActivity {
    EditText edt1,edt2;
    Button btn_save,btn_cancel;
    DatabaseReference ref;
    Model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        getSupportActionBar().hide();
        edt1=(EditText)findViewById(R.id.title_notes);
        edt2=(EditText)findViewById(R.id.title_disc);
        btn_save=(Button)findViewById(R.id.button_save);
        btn_cancel=(Button)findViewById(R.id.button_cancel);
        model=new Model();
        ref= FirebaseDatabase.getInstance().getReference().child("model");

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=edt1.getText().toString().trim();
                String task=edt2.getText().toString().trim();
                if(TextUtils.isEmpty(title)){
                    edt1.setError("Title Required");

                }
                else if(TextUtils.isEmpty(task)){
                    edt2.setError("Task required");
                }
                else{
                    model.setTitle(title);
                    model.setTask(task);
                    ref.push().setValue(model);
                    Toast.makeText(getApplicationContext(),"Task added!",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}