package com.example.sd.learningproject.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);

        List<ViewPagerData> datas = getDatas();

        for (int i = 0; i < 3; i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setCustomView(R.layout.layout_tab_layout);
            TextView titleTextView = (TextView) tab.getCustomView().findViewById(R.id.text_tab_title);
            titleTextView.setText(datas.get(i).getTitle());
            if (i == 0) {
                titleTextView.setTextColor(getResources().getColor(R.color.colorPrimary));
            }
            mTabLayout.addTab(tab);
        }

        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), datas));
        mViewPager.setOffscreenPageLimit(datas.size());
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    TextView textView = (TextView) tab.getCustomView().findViewById(R.id.text_tab_title);
                    textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab != null) {
                    TextView textView = (TextView) tab.getCustomView().findViewById(R.id.text_tab_title);
                    textView.setTextColor(getResources().getColor(R.color.primaryText));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    private List<ViewPagerData> getDatas() {
        List<ViewPagerData> datas = new ArrayList<>();

        ViewPagerData data = new ViewPagerData();
        data.setFragment(ViewPagerFragment.newInstance(1));
        data.setTitle("第1个");
        datas.add(data);

        ViewPagerData data1 = new ViewPagerData();
        data1.setFragment(ViewPagerFragment.newInstance(2));
        data1.setTitle("第2个");
        datas.add(data1);

        ViewPagerData data2 = new ViewPagerData();
        data2.setFragment(ViewPagerFragment.newInstance(3));
        data2.setTitle("第3个");
        datas.add(data2);

        return datas;
    }
}
