package com.example.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Politika extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politika);
        getSupportActionBar().setTitle("Пользовательское соглашение");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
