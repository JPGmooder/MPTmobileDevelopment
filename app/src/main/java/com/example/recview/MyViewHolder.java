package com.example.recview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView DenNedeli, P1, P2,P3,P4,P5;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        DenNedeli = itemView.findViewById(R.id.DenNedeli);
        P1 = itemView.findViewById(R.id.Para1);
        P2 = itemView.findViewById(R.id.Para2);
        P3 = itemView.findViewById(R.id.Para3);
        P4 = itemView.findViewById(R.id.Para4);
        P5 = itemView.findViewById(R.id.Para5);
    }
}
