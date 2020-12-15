package com.example.ecat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class section extends AppCompatActivity {
    RecyclerView recycle;
    RecyclerView.Adapter recycle_adapter;
    RecyclerView.LayoutManager recycle_layout;
    String section_names[]={"Mathematics","Physics","Chemistry"};
    int section_images_id[]={R.drawable.math,R.drawable.physics,R.drawable.chemistry};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        recycle=(RecyclerView)findViewById(R.id.recycler_view);
        recycle.setHasFixedSize(true);
        recycle_layout= new LinearLayoutManager(this);
        recycle.setLayoutManager(recycle_layout);
        recycle_adapter=new RecycleAdapter(this,section_names,section_images_id);
        recycle.setAdapter(recycle_adapter);

    }
}