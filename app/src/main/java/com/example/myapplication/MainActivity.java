package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.usage.ExternalStorageStats;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private  static final int REQUEST_CODE_READ_FILES = 1;
    private  static boolean READ_FILES_GRANTED = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int hasReadContactPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);

        if (hasReadContactPermission == PackageManager.PERMISSION_GRANTED)
        {
            READ_FILES_GRANTED = true;
        }
        else

            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_READ_FILES);
            }
        if (READ_FILES_GRANTED) {
            getFiles();
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_READ_FILES) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                READ_FILES_GRANTED = true;
            }
        }
        if(READ_FILES_GRANTED){
            getFiles();
        }
        else{
            Toast.makeText(this, "Требуется установить разрешения", Toast.LENGTH_LONG).show();
        }
    }

    private void getFiles(){
        ContentResolver contentResolver = getContentResolver();
        getExternalFilesDir("s");
        ArrayList<String> contacts = new ArrayList<String>();
        File myExternalFile = new File(getExternalFilesDir("Downloads"), "Sample.xls");

        contacts.add(myExternalFile.getName());

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, contacts);

        ListView contactList = findViewById(R.id.listview);
        // устанавливаем для списка адаптер
        contactList.setAdapter(adapter);
    }
}

