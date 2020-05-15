package com.example.diplom.traning.ofp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragments = new ArrayList<Fragment>();
private FragmentManager manager;
    public PageAdapter(FragmentManager manager) {
        super(manager);
    }

    public void addFragment(Fragment fragment) {
        mFragments.add(fragment);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        int position = mFragments.indexOf(object);
        return position == -1 ? POSITION_NONE : position;
    }
    public void Clear() {
        mFragments.clear();
    }
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
}