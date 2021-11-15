package com.example.resycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Model> movies;

    public RecyclerViewAdapter(Context context, List<Model> movies)
    {
        this.movies = movies;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerViewAdapter.ViewHolder holder, int position) {
        Model model = movies.get(position);
        holder.imgView.setImageResource(model.getImg());
        holder.nameMovie.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder
    {
        final ImageView imgView;
        final TextView nameMovie;
        ViewHolder( View itemView) {
            super(itemView);
            nameMovie = itemView.findViewById(R.id.txt);
            imgView = itemView.findViewById(R.id.img);

        }
    }

}
