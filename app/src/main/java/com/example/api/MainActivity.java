package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String login="";
    String password="";
    String email="";
    TextView mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mes = (TextView) findViewById(R.id.message);
    }

    public void onMyButtonClick(View view)
    {
        EditText log = (EditText) findViewById(R.id.login);
        login = log.getText().toString();
        EditText em = (EditText) findViewById(R.id.email);
        email = em.getText().toString();
        EditText ps = (EditText) findViewById(R.id.password);
        password = ps.getText().toString();
        Checkers t = new Checkers();
        ApiClass a = new ApiClass();

        if(!t.checkLogin(login))
        {
            mes.setText("Логин не соответствует валидации");
            return;
        }
        else{
            mes.setText("");
        }
        if(!t.validateEmail(email)){
            mes.setText("Email не соответствует валидации");
            return;
        }
        else{
            mes.setText("");
        }
        if(!t.checkPassword(password)){
            mes.setText("Пароль не соответствует валидации");
            return;
        }
        else{
            mes.setText("");
        }

        if(a.postData("https://cakeapi.trinitytuts.com/api/add",login,email,password)){
            mes.setText("Успешное соединение с API");
        }
        else{
            mes.setText("При работе с API возникла ошибка");
        }
    }
}