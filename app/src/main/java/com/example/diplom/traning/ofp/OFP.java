package com.example.diplom.traning.ofp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.HorizontalScrollView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.diplom.R;
import com.example.diplom.eat.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OFP extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter adapter;
    HorizontalScrollView sv;
    int position, position2;
    private FirebaseDatabase mDatabase;
    private FirebaseUser user;
    private DatabaseReference ListResult, done_week1, done_week2, done_week3, done_week4, done_week5, done_week6, done_week7, done_week8;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_f_p);
        tabLayout = findViewById(R.id.tablayout_id_ofp);
        viewPager = findViewById(R.id.viewpager_ofp);
        mDatabase = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        ListResult = mDatabase.getReference("Results").child(user.getUid());
        done_week1 = mDatabase.getReference("Results").child(user.getUid()).child("Week1");
        done_week2 = mDatabase.getReference("Results").child(user.getUid()).child("Week2");
        done_week3 = mDatabase.getReference("Results").child(user.getUid()).child("Week3");
        done_week4 = mDatabase.getReference("Results").child(user.getUid()).child("Week4");
        done_week5 = mDatabase.getReference("Results").child(user.getUid()).child("Week5");
        done_week6 = mDatabase.getReference("Results").child(user.getUid()).child("Week6");
        done_week7 = mDatabase.getReference("Results").child(user.getUid()).child("Week7");
        done_week8 = mDatabase.getReference("Results").child(user.getUid()).child("Week8");
        Bundle arguments = getIntent().getExtras();
        position = arguments.getInt("pos");
        sv = findViewById(R.id.scrool_ofp);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new Traning_vvedenie(), "Рекорды");
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
        loadPos();

    }

    private void loadPos() {
        ListResult.child("Week_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    position = Integer.parseInt(weight);
                    selectPage(position);
                } else {
                    position = 1;
                    selectPage(position);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position2 = tab.getPosition();
                String pos = Integer.toString(position2);
                ListResult.child("Week_done").setValue(pos);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });


    }

    void selectPage(int pageIndex) {
        tabLayout.setScrollPosition(pageIndex, 0f, true);
        viewPager.setCurrentItem(pageIndex);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
