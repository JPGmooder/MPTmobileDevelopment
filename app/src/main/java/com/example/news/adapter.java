package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<viewholder> {

    interface OnStateClickListener{
        void onStateClick(news items, int position);
    }
    private final OnStateClickListener onClickListener;

    Context context;
    List<news> news;

    public adapter(OnStateClickListener onClickListener, Context context, List<news> news) {
        this.onClickListener = onClickListener;
        this.context = context;
        this.news = news;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        news model = news.get(position);
        holder.nameNewsView.setText(model.getName());
        holder.textNewsView.setText(model.getText());
        holder.itemView.setOnClickListener(view -> {
            onClickListener.onStateClick(model, position);
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }
}
