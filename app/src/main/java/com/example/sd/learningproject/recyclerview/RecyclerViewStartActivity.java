package com.example.sd.learningproject.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

public class RecyclerViewStartActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_start);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.click_button1, R.id.click_button2, R.id.click_button3})
    void click(View view) {
        switch (view.getId()) {
            case R.id.click_button1:
                Intent intent = new Intent(this, RecyclerViewActivity.class);
                startActivity(intent);
                break;

            case R.id.click_button2:
                Intent intent1 = new Intent(this, StaggeredGridLayoutManagerActivity.class);
                startActivity(intent1);
                break;

            case R.id.click_button3:
                break;
        }
    }
}
