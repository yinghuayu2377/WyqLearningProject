package com.example.sd.learningproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

public class FragmentStartActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_fragment);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_normal, R.id.button_dynamic_add})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button_normal:
                Intent intent = new Intent(this, NormalFragmentActivity.class);
                startActivity(intent);
                break;

            case R.id.button_dynamic_add:
                Intent intent1 = new Intent(this, DynamicAddFragmentActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
