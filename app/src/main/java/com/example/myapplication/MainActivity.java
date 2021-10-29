package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    String actualText;
    ListView list;
    String[] device = {"Планшеты", "Телефоны", "Ноутбуки", "Компьютеры"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actualText = "";
        list = findViewById(R.id.listview);
    //    list = findViewById()
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, device);
    list.setAdapter(adapter);
    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String pressedText = ((TextView)view).getText().toString() + ',';

            if (actualText.contains(pressedText)) {
               actualText = actualText.replace(pressedText, "");
            } else {
                actualText += pressedText;
            }
            Toast.makeText(getApplicationContext(), actualText, Toast.LENGTH_SHORT).show();
        }
    });
    }
}