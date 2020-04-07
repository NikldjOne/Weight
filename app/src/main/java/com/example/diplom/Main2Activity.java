package com.example.diplom;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.diplom.R.id.nav_home;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView bottomNav=findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment= null;

                    switch (menuItem.getItemId()){
                        case nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_eat:
                            selectedFragment = new EatFragment();
                            break;
                        case R.id.nav_traning_home:
                            selectedFragment = new TraningFragment();
                            break;
                        case R.id.nav_raz:
                            selectedFragment = new IntellectFragment();
                            break;
                        case R.id.nav_users:
                            selectedFragment = new UsersFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return  true;
                }
            };

}
