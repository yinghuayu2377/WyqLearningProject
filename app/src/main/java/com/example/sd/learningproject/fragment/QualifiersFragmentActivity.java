package com.example.sd.learningproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.sd.learningproject.R;

/**
 * 通过限定符实现通过分辨率决定加载单页/双页模式
 */
public class QualifiersFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualifiers_fragment);
    }
}
