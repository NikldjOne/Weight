package com.example.diplom.traning.ofp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.diplom.R;

public class Traning extends Fragment {
    View view;
    Button btn_day1, btn_day3, btn_day5, btn_day7, btn_shil, btn_shil2, btn_shil3;
    PageAdapter pagerAdapter;
    FragmentTransaction fTrans;
    Shil_fragment fragmentShil = new Shil_fragment();
    Day7_fragment fragmentSeven = new Day7_fragment();
    Day5_fragment fragmentFive = new Day5_fragment();
    Day3_fragment fragmentThree = new Day3_fragment();
    Day1_fragment fragmentOne = new Day1_fragment();
    RelativeLayout rel_day1, rel_day2, rel_day3, rel_day4, rel_day5, rel_day6, rel_day7;

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
        rel_day1 = view.findViewById(R.id.day1_rel);
        rel_day2 = view.findViewById(R.id.day2_rel);
        rel_day3 = view.findViewById(R.id.day3_rel);
        rel_day4 = view.findViewById(R.id.day4_rel);
        rel_day5 = view.findViewById(R.id.day5_rel);
        rel_day6 = view.findViewById(R.id.day6_rel);
        rel_day7 = view.findViewById(R.id.day7_rel);
        btn_day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day1Btn();
                inactive();
                rel_day1.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day3();
                inactive();
                rel_day3.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day5();
                inactive();
                rel_day5.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day7();
                inactive();
                rel_day7.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_shil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day_shil();
                inactive();
                rel_day2.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_shil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day_shil();
                inactive();
                rel_day4.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_shil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day_shil();
                inactive();
                rel_day6.setBackgroundResource(R.drawable.inset);
            }
        });
        Day1();
        return view;
    }

    private void inactive(){
        rel_day1.setBackgroundResource(R.drawable.inset_inactive);
        rel_day2.setBackgroundResource(R.drawable.inset_inactive);
        rel_day3.setBackgroundResource(R.drawable.inset_inactive);
        rel_day4.setBackgroundResource(R.drawable.inset_inactive);
        rel_day5.setBackgroundResource(R.drawable.inset_inactive);
        rel_day6.setBackgroundResource(R.drawable.inset_inactive);
        rel_day7.setBackgroundResource(R.drawable.inset_inactive);
    }
    private void Day_shil() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragmentShil);
        fTrans.commit();
    }

    private void Day7() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragmentSeven);
        fTrans.commit();

    }

    private void Day5() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragmentFive);
        fTrans.commit();
    }

    private void Day3() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragmentThree);
        fTrans.commit();
    }

    private void Day1() {
        rel_day1.setBackgroundResource(R.drawable.inset);
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragmentOne);
        fTrans.commit();
    }

    private void Day1Btn() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragmentOne);
        fTrans.commit();
    }
}
