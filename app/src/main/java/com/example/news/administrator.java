package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class administrator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        List<news> news = new ArrayList<news>();
        EditText editText_NameNews = findViewById(R.id.editText_NameNews);
        EditText editText_TextNews = findViewById(R.id.editText_TextNews);
        dbhelper dbhelper = new dbhelper(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Cursor cursor = dbhelper.getdataNews();
        adapter adapter;

        final int[] position = new int[1];
        // определяем слушателя нажатия элемента в списке
        com.example.news.adapter.OnStateClickListener stateClickListener = new com.example.news.adapter.OnStateClickListener() {
            @Override
            public void onStateClick(news items, int pos) {
                editText_NameNews.setText(items.getName());
                editText_TextNews.setText(items.getText());
                position[0] = pos;
            }
        };

        //Проверка на наличие данных
        if (cursor.getCount() != 0){
            //Цикл для перебора и объединения данных
            while (cursor.moveToNext()){
                news.add(new news(cursor.getString(0), cursor.getString(1)));
            }
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adapter(stateClickListener, getApplicationContext(), news);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.btnAddNews).setOnClickListener(view -> {
            if (!editText_NameNews.getText().toString().trim().equals("") && !editText_TextNews.getText().toString().trim().equals("")) {
                Boolean checkInsertData = dbhelper.insertNews(editText_NameNews.getText().toString(), editText_TextNews.getText().toString());
                if (checkInsertData) {
                    news.add(news.size(), new news(editText_NameNews.getText().toString(), editText_TextNews.getText().toString()));
                    adapter.notifyItemInserted(news.size());
                    Toast.makeText(getApplicationContext(), "Данные успешно добавлены", Toast.LENGTH_LONG).show();
                } else Toast.makeText(getApplicationContext(), "Произошла ошибка!", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(getApplicationContext(), "Не все поля заполнены!", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.btnDeleteNews).setOnClickListener(view -> {
            Boolean checkInsertData = dbhelper.deleteNews(editText_NameNews.getText().toString());
            if (checkInsertData) {
                news.remove(position[0]);
                adapter.notifyItemRemoved(position[0]);
                Toast.makeText(getApplicationContext(), "Данные успешно удалены", Toast.LENGTH_LONG).show();
            } else Toast.makeText(getApplicationContext(), "Произошла ошибка!", Toast.LENGTH_LONG).show();
        });

        findViewById(R.id.btnEditNews).setOnClickListener(view -> {
            Boolean checkInsertData = dbhelper.updateNews(editText_NameNews.getText().toString(), editText_TextNews.getText().toString());
            if (checkInsertData){
                news.set(position[0], new news(editText_NameNews.getText().toString(), editText_TextNews.getText().toString()));
                adapter.notifyItemChanged(position[0]);
                Toast.makeText(getApplicationContext(), "Данные успешно обновлены", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(getApplicationContext(), "Произошла ошибка", Toast.LENGTH_LONG).show();
        });

        findViewById(R.id.btnExit).setOnClickListener(view -> {
            Intent intent = new Intent(administrator.this, MainActivity.class);
            startActivity(intent);
        });
    }
}