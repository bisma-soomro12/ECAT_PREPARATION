package com.example.ecat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;

public class keep_notes1 extends AppCompatActivity {
    RecyclerView rec_notes;
    FloatingActionButton btn_plus;
    DatabaseReference reff;
    EditText edt1,edt2;
    Button btn_save,btn_cancel;
    Model model;
    DatabaseReference ref;
    ImageButton back_button;

    //FirebaseUser users;
    //ProgressDialog loader;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_notes1);
        getSupportActionBar().hide();
        rec_notes=(RecyclerView)findViewById(R.id.recycler_view_notes);
        btn_plus=(FloatingActionButton)findViewById(R.id.notes_floating_button);
        back_button=(ImageButton)findViewById(R.id.backButton);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setReverseLayout(true);
        manager.setStackFromEnd(true);
        rec_notes.setHasFixedSize(true);
        rec_notes.setLayoutManager(manager);
        model=new Model();
        ref= FirebaseDatabase.getInstance().getReference().child("model");

        //loader= new ProgressDialog(this);

        //reff= FirebaseDatabase.getInstance().getReference().child("Task");








// listeners for all three buttons
        // for plus floating button and for save and cancel button of dailoge box
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(keep_notes1.this,add_notes1.class);
                startActivity(intent);
                //addTask();
            }
        });
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(keep_notes1.this,home.class);
                startActivity(intent);
            }
        });


    }

    private void addTask() {
        AlertDialog.Builder myDailog = new AlertDialog.Builder(this);
        LayoutInflater inflate= LayoutInflater.from(this);

        View myView =inflate.inflate(R.layout.activity_add_notes,null);
        myDailog.setView(myView);

        AlertDialog dialog = myDailog.create();
        dialog.setCancelable(false);

        dialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions<Model> item_opt = new FirebaseRecyclerOptions.Builder<Model>()
                .setQuery(ref, Model.class)
                .build();
        FirebaseRecyclerAdapter<Model, MyViewHolder> adapter = new FirebaseRecyclerAdapter<Model, MyViewHolder>(item_opt) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i, @NonNull Model model) {
                myViewHolder.setTask(model.getTitle());
                myViewHolder.setDis(model.getTask());
            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view;
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_item,parent,false);
                return new MyViewHolder(view);
            }
        };
        rec_notes.setAdapter(adapter);
        adapter.startListening();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public MyViewHolder(View ItemView){
            super(ItemView);
            mView=ItemView;
        }
        public void setTask(String task){
            TextView taskTitle=mView.findViewById(R.id.recycle_title);
            taskTitle.setText(task);

        }
        public void setDis(String task){
            TextView taskDis=mView.findViewById(R.id.recycle_task);
            taskDis.setText(task);
        }
    }
}