package com.example.sqllite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, phone, dateOfBirth;
    Button insert, update, delete, select;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.txtName);
        phone = findViewById(R.id.txtNumber);
        dateOfBirth = findViewById(R.id.txtDate);
        insert = findViewById(R.id.btnInsert);
        delete = findViewById(R.id.btnDelete);
        update = findViewById(R.id.btnUpdate);
        select = findViewById(R.id.btnSelecet);
        databaseHelper = new DatabaseHelper(this);

        delete.setOnClickListener(view -> {
            Boolean checkInsertData = databaseHelper.Delete(name.getText().toString());
            if (checkInsertData)
                Toast.makeText(getApplicationContext(), "Данные успешно удалены", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Произошла ошибка", Toast.LENGTH_LONG).show();
        });

        update.setOnClickListener(view -> {
            Boolean checkInsertData = databaseHelper.Update(name.getText().toString(), phone.getText().toString(), dateOfBirth.getText().toString());
            if (checkInsertData)
                Toast.makeText(getApplicationContext(), "Данные успешно обновлены", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Произошла ошибка", Toast.LENGTH_LONG).show();
        });

        insert.setOnClickListener(view -> {
            Boolean checkInsertData = databaseHelper.insert(name.getText().toString(), phone.getText().toString(), dateOfBirth.getText().toString());
            if (checkInsertData)
                Toast.makeText(getApplicationContext(), "Данные успешно добавлены", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Произошла ошибка", Toast.LENGTH_LONG).show();
        });
        select.setOnClickListener(view -> {
            Cursor res = databaseHelper.getdata();
                    if (res.getCount() == 0)
                    {
                        Toast.makeText(MainActivity.this, "Нет данных", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext())
                    {
                        buffer.append("Имя: ").append(res.getString(0)).append("\n");
                        buffer.append("Тел. номер: ").append(res.getString(1)).append("\n");
                        buffer.append("Дата рождения: ").append(res.getString(2)).append("\n");

                    }
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Данные пользователей");
                    builder.setMessage(buffer.toString());
                    builder.show();
        });
        select.setOnClickListener(view -> {
            Cursor res = databaseHelper.getdata();
            if (res.getCount() == 0)
            {
                Toast.makeText(MainActivity.this, "Нет данных", Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext())
            {
                buffer.append("Имя: ").append(res.getString(0)).append("\n");
                buffer.append("Тел. номер: ").append(res.getString(1)).append("\n");
                buffer.append("Дата рождения: ").append(res.getString(2)).append("\n");

            }
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(true);
            builder.setTitle("Данные пользователей");
            builder.setMessage(buffer.toString());
            builder.show();
        });
        select.setOnClickListener(view -> {
            Cursor res = databaseHelper.getdata();
            if (res.getCount() == 0)
            {
                Toast.makeText(MainActivity.this, "Нет данных", Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext())
            {
                buffer.append("Имя: ").append(res.getString(0)).append("\n");
                buffer.append("Тел. номер: ").append(res.getString(1)).append("\n");
                buffer.append("Дата рождения: ").append(res.getString(2)).append("\n");

            }
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(true);
            builder.setTitle("Данные пользователей");
            builder.setMessage(buffer.toString());
            builder.show();
        });
    }
}