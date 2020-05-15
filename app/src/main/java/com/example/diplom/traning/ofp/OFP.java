package com.example.diplom.traning.ofp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.diplom.R;
import com.example.diplom.eat.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class OFP extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager, viewPager2;
    ViewPagerAdapter adapter, adapter2;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_f_p);
        tabLayout = findViewById(R.id.tablayout_id_ofp);
        viewPager = findViewById(R.id.viewpager_ofp);
        viewPager2 = findViewById(R.id.viewpager_ofp_traning);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new Traning(), "Неделя 1");
        adapter.AddFragment(new Traning(), "Неделя 2");
        adapter.AddFragment(new Traning(), "Неделя 3");
        adapter.AddFragment(new Traning(), "Неделя 4");
        adapter.AddFragment(new Traning(), "Неделя 5");
        adapter.AddFragment(new Traning(), "Неделя 6");
        adapter.AddFragment(new Traning(), "Неделя 7");
        adapter.AddFragment(new Traning(), "Неделя 8");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#80778899"), Color.parseColor("#008577"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout_6);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
