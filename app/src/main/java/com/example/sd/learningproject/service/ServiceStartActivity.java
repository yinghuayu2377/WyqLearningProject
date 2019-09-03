package com.example.sd.learningproject.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.service.service.FrontDeskServiceActivity;
import com.example.sd.learningproject.service.service.IntentServiceActivity;
import com.example.sd.learningproject.service.service.MyServiceActivity;
import com.example.sd.learningproject.service.thread.AsyncTaskActivity;
import com.example.sd.learningproject.service.thread.ThreadActivity;

public class ServiceStartActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button mButton1;
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.button3)
    Button mButton3;
    @BindView(R.id.button4)
    Button mButton4;
    @BindView(R.id.button5)
    Button mButton5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_start);
        ButterKnife.bind(this);

        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(getString(R.string.text_asynchronization_thread));
        mButton2.setVisibility(View.VISIBLE);
        mButton2.setText(getString(R.string.text_async_task));
        mButton3.setVisibility(View.VISIBLE);
        mButton3.setText(getString(R.string.text_service));
        mButton4.setVisibility(View.VISIBLE);
        mButton4.setText(getString(R.string.front_desk_service));
        mButton5.setVisibility(View.VISIBLE);
        mButton5.setText(getString(R.string.text_intent_service));
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                gotoActivity(ThreadActivity.class);
                break;

            case R.id.button2:
                gotoActivity(AsyncTaskActivity.class);
                break;

            case R.id.button3:
                gotoActivity(MyServiceActivity.class);
                break;

            case R.id.button4:
                gotoActivity(FrontDeskServiceActivity.class);
                break;

            case R.id.button5:
                gotoActivity(IntentServiceActivity.class);
                break;
        }
    }

    private void gotoActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
