package com.example.diplom.eat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> FragmentListStrings = new ArrayList<>();
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);

    }
    @Override
    public int getCount() {
        return FragmentListStrings.size();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentListStrings.get(position);
    }
    public void AddFragment(Fragment fragment, String Title){
        fragmentList.add(fragment);
        FragmentListStrings.add(Title);
    }
}
