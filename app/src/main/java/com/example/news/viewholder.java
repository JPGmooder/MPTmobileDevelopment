package com.example.news;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewholder extends RecyclerView.ViewHolder {

    TextView nameNewsView, textNewsView;

    public viewholder(@NonNull View itemView) {
        super(itemView);
        nameNewsView = itemView.findViewById(R.id.txtNameNews);
        textNewsView = itemView.findViewById(R.id.txtTextNews);
    }
}
