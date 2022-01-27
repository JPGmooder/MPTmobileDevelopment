package com.example.recview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Item> items = new ArrayList<Item>();
    Boolean Chislitel = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recycleview);

        GetData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items ));


    }

    private void GetData()
    {
        if(Chislitel == true) {
            items.add(new Item("Понедельник", "Пара 1:", R.drawable.color1,
                    "Пара 2:", R.drawable.color1,
                    "Пара 3:", R.drawable.color1,
                    "Пара 4:", R.drawable.color2,
                    "Пара 5:", R.drawable.color2
            ));
            items.add(new Item("Вторник", "Пара 1:", R.drawable.color1,
                    "Пара 2:", R.drawable.color1,
                    "Пара 3:", R.drawable.color2,
                    "Пара 4:", R.drawable.color1,
                    "Пара 5:", R.drawable.color1
            ));
            items.add(new Item("Среда", "Пара 1:", R.drawable.color1,
                    "Пара 2:", R.drawable.color1,
                    "Пара 3:", R.drawable.color1,
                    "Пара 4:", R.drawable.color1,
                    "Пара 5:", R.drawable.color1
            ));
            items.add(new Item("Четверг", "Пара 1:", R.drawable.color1,
                    "Пара 2:", R.drawable.color2,
                    "Пара 3:", R.drawable.color1,
                    "Пара 4:", R.drawable.color1,
                    "Пара 5:", R.drawable.color1
            ));
            items.add(new Item("Пятница", "Пара 1:", R.drawable.color2,
                    "Пара 2:", R.drawable.color1,
                    "Пара 3:", R.drawable.color1,
                    "Пара 4:", R.drawable.color1,
                    "Пара 5:", R.drawable.color1
            ));
        }
        else {
            items.add(new Item("Понедельник", "Пара 1:", R.drawable.color1,
                    "Пара 2:", R.drawable.color1,
                    "Пара 3:", R.drawable.color3,
                    "Пара 4:", R.drawable.color1,
                    "Пара 5:", R.drawable.color3
            ));
            items.add(new Item("Вторник", "Пара 1:", R.drawable.color1,
                    "Пара 2:", R.drawable.color1,
                    "Пара 3:", R.drawable.color1,
                    "Пара 4:", R.drawable.color1,
                    "Пара 5:", R.drawable.color1
            ));
            items.add(new Item("Среда", "Пара 1:", R.drawable.color1,
                    "Пара 2:", R.drawable.color1,
                    "Пара 3:", R.drawable.color1,
                    "Пара 4:", R.drawable.color1,
                    "Пара 5:", R.drawable.color1
            ));
            items.add(new Item("Четверг", "Пара 1:", R.drawable.color1,
                    "Пара 2:", R.drawable.color3,
                    "Пара 3:", R.drawable.color1,
                    "Пара 4:", R.drawable.color1,
                    "Пара 5:", R.drawable.color1
            ));
            items.add(new Item("Пятница", "Пара 1:", R.drawable.color3,
                    "Пара 2:", R.drawable.color1,
                    "Пара 3:", R.drawable.color1,
                    "Пара 4:", R.drawable.color1,
                    "Пара 5:", R.drawable.color1
            ));
        }
    }
}