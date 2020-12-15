package com.example.ecat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;

import static com.example.ecat.R.layout.section_item;
import static com.example.ecat.R.layout.topics;

public class TopicsRecyclerAdapter extends RecyclerView.Adapter<TopicsRecyclerAdapter.ViewHolder>{
    Context context;
    String[] topics_name;
    String[] topic_dis;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view= inflater.inflate(topics,parent,false);
        TopicsRecyclerAdapter.ViewHolder viewholder=new TopicsRecyclerAdapter.ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_TT.setText(topics_name[position]);
        holder.txt_TDis.setText(topic_dis[position]);
        //Intent intent=new Intent(context,question.class);
        //context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return topics_name.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_TT;
        TextView txt_TDis;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           txt_TT=itemView.findViewById(R.id.recycle_topic);
            txt_TDis=itemView.findViewById(R.id.recycle_topic_dis);
        }
    }

    public TopicsRecyclerAdapter(Context context, String[] topics_name, String[] topic_dis) {
        this.context = context;
        this.topics_name = topics_name;
        this.topic_dis = topic_dis;
    }

}


