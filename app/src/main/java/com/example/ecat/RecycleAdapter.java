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

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>
{
    Context context;
    String[] section_name;
    int[] section_images;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_section;
        CircularImageView circular_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_section=itemView.findViewById(R.id.recycle_text);
            circular_image=itemView.findViewById(R.id.image_view_circle);


        }
    }

    public RecycleAdapter(Context context, String[] section_name, int[] section_images) {
        this.context = context;
        this.section_name = section_name;
        this.section_images = section_images;
    }

    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view= inflater.inflate(section_item,parent,false);
        ViewHolder viewholder=new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder, int position) {
        holder.txt_section.setText(section_name[position]);
        holder.circular_image.setImageResource(section_images[position]);
        Intent intent=new Intent(context,question.class);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return section_name.length;
    }


}
