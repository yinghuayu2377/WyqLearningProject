package com.example.sd.learningproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

/**
 * 动态添加fragment
 */
public class DynamicAddFragmentActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_add_fragment);

        ButterKnife.bind(this);
        replaceFragment(new RightFragment());
    }

    @OnClick({R.id.button})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button:
                replaceFragment(new LeftFragment());
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.layout_right, fragment);
        transaction.addToBackStack(null);  // 将事务添加到Fragment事务返回栈，点击back按钮后撤销事务并回退到上一个Fragment
        transaction.commit();
    }
}
