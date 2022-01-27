package com.example.recview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Item> imems;

    public MyAdapter(Context context, List<Item> imems) {
        this.context = context;
        this.imems = imems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.DenNedeli.setText(imems.get(position).getDenNedeli());

        holder.P1.setText(imems.get(position).Para1);
        Drawable drawable1 = context.getResources().getDrawable(imems.get(position).Photo1);
        holder.P1.setBackground(drawable1);

        holder.P2.setText(imems.get(position).Para2);
        Drawable drawable2 = context.getResources().getDrawable(imems.get(position).Photo2);
        holder.P2.setBackground(drawable2);

        holder.P3.setText(imems.get(position).Para3);
        Drawable drawable3 = context.getResources().getDrawable(imems.get(position).Photo3);
        holder.P3.setBackground(drawable3);

        holder.P4.setText(imems.get(position).Para4);
        Drawable drawable4 = context.getResources().getDrawable(imems.get(position).Photo4);
        holder.P4.setBackground(drawable4);

        holder.P5.setText(imems.get(position).Para5);
        Drawable drawable5 = context.getResources().getDrawable(imems.get(position).Photo5);
        holder.P1.setBackground(drawable5);

    }

    @Override
    public int getItemCount() {
        return imems.size();
    }
}
