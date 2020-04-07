package com.example.diplom;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
Adapter adapter;
List<Model> models;
Integer[] colors =null;
ArgbEvaluator argbEvaluator = new ArgbEvaluator();
private Timer timer;
private  int current_postition;
private LinearLayout dotsLayout;
private  int custom_position=0;
private  int colors2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotsLayout = findViewById(R.id.dotsContainer);

        models = new ArrayList<>();
        models.add(new Model("ТРАНСФОРМАЦИЯ ТЕЛА","Тренировки нового уровня. Наращивай\n" +
                "мышцы и пали жир, построй тело атлета."));
        models.add(new Model("Test2","TEST_TEST_TEST_TEST_TEST"));
        models.add(new Model("Test2","TEST_TEST_TEST_TEST_TEST"));
        models.add(new Model("Test2","TEST_TEST_TEST_TEST_TEST"));

        adapter = new Adapter(models,this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
           startActivity(new Intent(MainActivity.this, Main2Activity.class));
           finish();
        }


        final Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
        };
        colors = colors_temp;
        createSlideShow();
        prepareDots(custom_position++);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position<(adapter.getCount()-1)&&position<(colors.length-1)){
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position+1]
                            )

                    );
                }else {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

                prepareDots(custom_position=position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });


    }

    public void RegClick(View view) {
        switch (view.getId()) {
            case R.id.btReg:
                Intent intent = new Intent(this, Registration.class);
                startActivity(intent);
                finish();
        }
    }

    public void Loginclick(View view) {
        switch (view.getId()) {
            case R.id.btLogin:
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                finish();
        }
    }
    private void createSlideShow(){
        final Handler handler = new Handler();
        final  Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(current_postition==models.size())
                    current_postition = 0;
                viewPager.setCurrentItem(current_postition++,true);

            }
        };
    }

    private void prepareDots(int currentSlidePosition) {
        if (dotsLayout.getChildCount() > 0)
            dotsLayout.removeAllViews();

        ImageView dots[] = new ImageView[4];

        for (int i = 0; i < 4; i++) {
            dots[i] = new ImageView(this);
            if (i == currentSlidePosition)
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dot));
            else
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.inactive_dot));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(4, 0, 4, 0);

            dotsLayout.addView(dots[i], layoutParams);
        }
    }
}
