package com.example.jsonserialization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txtView;
    String futureJokeString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        txtView = findViewById(R.id.txt);
        btn.setOnClickListener(v -> new JokeLoader().execute());
    }

    private class JokeLoader extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected Void doInBackground(Void... voids)
        {
            System.out.println("1");
            String jsonString = getJson("https://api.chucknorris.io/jokes/random");
            System.out.println("aaa");
            try {
                JokeModel newJoke = new JokeModel(new JSONObject(jsonString));
                futureJokeString = newJoke.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            futureJokeString = "";
            txtView.setText("Loading...");
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            if (!futureJokeString.equals(""))
                txtView.setText(futureJokeString);
        }
    }

    private String getJson (String link)
    {
        String data = "";
        try {
            URL url = new URL(link.trim());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                data = reader.readLine();
                urlConnection.disconnect();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return  data;
    }
}