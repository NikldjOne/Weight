package com.example.diplom;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.diplom.eat.Massa_Fragment;
import com.example.diplom.eat.Syhka_Fragment;
import com.example.diplom.eat.ViewPagerAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class EatFragment extends Fragment {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    ViewPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eat, container, false);
        tabLayout =  view.findViewById(R.id.tablayout_id);
        appBarLayout =  view.findViewById(R.id.appbarid);
        viewPager =  view.findViewById(R.id.viewpager_2);
        adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.AddFragment(new Syhka_Fragment(), "Сушка");
        adapter.AddFragment(new Massa_Fragment(), "Масса");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#80778899"), Color.parseColor("#008577"));
        return view;
    }
}
