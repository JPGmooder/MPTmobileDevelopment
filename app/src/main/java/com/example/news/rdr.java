package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class rdr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        List<news> news = new ArrayList<news>();
        dbhelper dbhelper = new dbhelper(this);
        Cursor cursor = dbhelper.getdataNews();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        adapter adapter;

        administrator administrator = new administrator();
        //Проверка на наличие данных
        if (cursor.getCount() != 0){
            //Цикл для перебора и объединения данных
            while (cursor.moveToNext()){
                news.add(new news(cursor.getString(0), cursor.getString(1)));
            }
        }
        com.example.news.adapter.OnStateClickListener stateClickListener = new com.example.news.adapter.OnStateClickListener() {
            @Override
            public void onStateClick(news items, int pos) {
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adapter(stateClickListener, getApplicationContext(), news);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.btnExit).setOnClickListener(view -> {
            Intent intent = new Intent(rdr.this, MainActivity.class);
            startActivity(intent);
        });
    }
}