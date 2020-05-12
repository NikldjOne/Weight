package com.example.diplom.eat.menu_eat_syhka;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplom.R;

public class Obed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obed);
        getSupportActionBar().setTitle("Обед");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
