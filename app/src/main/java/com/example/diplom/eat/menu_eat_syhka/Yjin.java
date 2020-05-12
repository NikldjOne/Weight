package com.example.diplom.eat.menu_eat_syhka;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplom.R;

public class Yjin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yjin);
        getSupportActionBar().setTitle("Ужин");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
