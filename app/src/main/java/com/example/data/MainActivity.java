package com.example.data;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtDateTime;
    Button btnTime, btnDate;
    Calendar dateTime = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDateTime = findViewById(R.id.txtDateTime);
        btnTime = findViewById(R.id.btnTime);
        btnDate = findViewById(R.id.btnDate);
        //установка начальной даты и время
        txtDateTime.setText(DateUtils.formatDateTime(this,dateTime.getTimeInMillis(),DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_SHOW_TIME));
        //установка обработчика выбора даты
        DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOFmONTH) {
                dateTime.set(Calendar.YEAR,year);
                dateTime.set(Calendar.MONTH,monthOfYear);
                dateTime.set(Calendar.DAY_OF_MONTH,dayOFmONTH);
                txtDateTime.setText(DateUtils.formatDateTime(getApplicationContext(),dateTime.getTimeInMillis(),
                        DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_SHOW_TIME));
            }
        };

        TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int Minutes) {
                dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                dateTime.set(Calendar.MINUTE, Minutes);
                txtDateTime.setText(DateUtils.formatDateTime(getApplicationContext(),dateTime.getTimeInMillis(),
                        DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_SHOW_TIME));
            }
        };
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(MainActivity.this,t,dateTime.get(Calendar.HOUR_OF_DAY),dateTime.get(Calendar.MINUTE),true).show();
            }
        });

        btnDate.setOnClickListener(view -> new DatePickerDialog(MainActivity.this,d,dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show());






    }
}