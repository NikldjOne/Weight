package com.example.diplom.traning.ofp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.diplom.R;

public class Traning extends Fragment {
    View view;
    Button btn_day1, btn_day3, btn_day5, btn_day7, btn_shil, btn_shil2, btn_shil3;
    PageAdapter pagerAdapter;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.traning_ofp_fragment, container, false);
        btn_day1 = view.findViewById(R.id.btn_day1);
        btn_day3 = view.findViewById(R.id.btn_day3);
        btn_day5 = view.findViewById(R.id.btn_day5);
        btn_day7 = view.findViewById(R.id.btn_day7);
        btn_shil = view.findViewById(R.id.btn_shil);
        btn_shil2 = view.findViewById(R.id.btn_shil2);
        btn_shil3 = view.findViewById(R.id.btn_shil3);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_ofp_traning);
        btn_day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day1();
            }
        });
        btn_day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day3();
            }
        });
        btn_day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day5();
            }
        });
        btn_day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day7();
            }
        });
        btn_shil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day_shil();
            }
        });
        btn_shil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day_shil();
            }
        });
        btn_shil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day_shil();
            }
        });
        return view;
    }

    private void Day_shil() {
        Shil_fragment fragmentOne = new Shil_fragment();
        pagerAdapter = new PageAdapter(getChildFragmentManager());
        pagerAdapter.Clear();
        viewPager.setAdapter(pagerAdapter);
        pagerAdapter.addFragment(fragmentOne);
        viewPager.setAdapter(pagerAdapter);
    }

    private void Day7() {
        Day7_fragment fragmentOne = new Day7_fragment();
        pagerAdapter = new PageAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(fragmentOne);
        viewPager.setAdapter(pagerAdapter);
    }

    private void Day5() {
        Day5_fragment fragmentOne = new Day5_fragment();
        pagerAdapter = new PageAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(fragmentOne);
        viewPager.setAdapter(pagerAdapter);
    }

    private void Day3() {
        Day3_fragment fragmentOne = new Day3_fragment();
        pagerAdapter = new PageAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(fragmentOne);
        viewPager.setAdapter(pagerAdapter);
    }

    private void Day1() {
        Day1_fragment fragmentOne = new Day1_fragment();
        pagerAdapter = new PageAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(fragmentOne);
        viewPager.setAdapter(pagerAdapter);
    }
}
