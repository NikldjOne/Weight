package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Konfidentional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfidentional);
        getSupportActionBar().setTitle("Политика конфиденциальности");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
