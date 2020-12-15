package com.example.ecat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class KeepNotes extends AppCompatActivity {
    ImageButton btn_save;
    EditText txt_notes;
    ArrayList<String> item;
    ArrayAdapter<String> itemsAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_notes);
        getSupportActionBar().hide();
        btn_save=(ImageButton)findViewById(R.id.save);
        txt_notes=(EditText)findViewById(R.id.note);
        listView=(ListView)findViewById(R.id.list_view);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(v);
            }

           
        });
        item=new ArrayList<>();
        itemsAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,item);
        listView.setAdapter(itemsAdapter);
        setUpListViewListner();
    }

    private void setUpListViewListner() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context=getApplicationContext();
                Toast.makeText(context,"note deleted!",Toast.LENGTH_LONG).show();
                item.remove(position);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem(View v) {
        txt_notes=(EditText)findViewById(R.id.note);
        String str=txt_notes.getText().toString();
        if(!str.equals("")){
            itemsAdapter.add(str);
            txt_notes.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(),"please enter text",Toast.LENGTH_LONG).show();
        }
    }
}