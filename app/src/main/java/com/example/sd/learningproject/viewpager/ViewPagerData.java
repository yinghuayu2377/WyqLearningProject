package com.example.sd.learningproject.viewpager;

import android.support.v4.app.Fragment;

public class ViewPagerData {

    private Fragment fragment;
    private String title;

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
