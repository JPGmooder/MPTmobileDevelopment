package com.example.picasso;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    //библеотека глайд
//
    ImageView img;
    String ssilka;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.photo);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(view -> new JokeLoader().execute());

    }

    private class JokeLoader extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            String jsonStr = getJson("https://api.thecatapi.com/v1/images/search");
            try {
                System.out.println(jsonStr);

                JSONArray jsonObject = new JSONArray(jsonStr);
                ssilka = jsonObject.getJSONObject(0).getString("url");


            } catch (JSONException a) {
                a.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ssilka = "";
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);

            if (ssilka != null) {
                Glide
                        .with(getApplicationContext())
                        .load(ssilka)
                        .into(img);
            }
        }

        private String getJson(String link) {
            String data = "";
            try {
                URL url = new URL(link);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                    data = r.readLine();
                    urlConnection.disconnect();
                }

            } catch (IOException a) {
                a.printStackTrace();
            }
            return data;
        }
    }
}
