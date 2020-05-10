package com.example.diplom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eat, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) view.findViewById(R.id.appbarid);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_2);
        FragmentManager fragManager = getActivity().getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(fragManager);
        adapter.AddFragment(new Syhka_Fragment(),"Syhka");
        adapter.AddFragment(new Massa_Fragment(), "Massa");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;


    }
}
