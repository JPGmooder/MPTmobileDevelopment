package com.example.resycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Model> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setData();

        RecyclerView recyclerView = findViewById(R.id.recycler);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, movies);
        recyclerView.setAdapter(adapter);
    }

    private void setData()
    {
        movies.add(new Model(R.drawable.ic_launcher_foreground, "Андроид"));
        movies.add(new Model(R.drawable.ic_launcher_background, "Задник андроида"));

    }
}