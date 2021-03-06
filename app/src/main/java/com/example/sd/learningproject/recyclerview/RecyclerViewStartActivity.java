package com.example.sd.learningproject.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.RecyclerViewOpenOrCloseActivity;
import com.example.sd.learningproject.recyclerview.complexrecyclerview.ComplexRecyclerViewActivity;
import com.example.sd.learningproject.recyclerview.nestrecyclerview.NestRecyclerViewActivity;

public class RecyclerViewStartActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_start);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.click_button1, R.id.click_button2, R.id.click_button3, R.id.click_button4, R.id.click_button5, R.id.click_button6})
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
                Intent intent2 = new Intent(this, GridLayoutManagerActivity.class);
                startActivity(intent2);
                break;

            case R.id.click_button4:
                Intent intent3 = new Intent(this, ComplexRecyclerViewActivity.class);
                startActivity(intent3);
                break;

            case R.id.click_button5:
                Intent intent4 = new Intent(this, NestRecyclerViewActivity.class);
                startActivity(intent4);
                break;

            case R.id.click_button6:
                Intent intent5 = new Intent(this, RecyclerViewOpenOrCloseActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
