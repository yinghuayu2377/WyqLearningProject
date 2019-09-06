package com.example.sd.learningproject.viewpager;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<ViewPagerData> mDatas;

    public ViewPagerAdapter(FragmentManager manager, List<ViewPagerData> list) {
        super(manager);
        this.mDatas = list;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Fragment getItem(int i) {
        return mDatas.get(i).getFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mDatas.get(position).getTitle();
    }
}
