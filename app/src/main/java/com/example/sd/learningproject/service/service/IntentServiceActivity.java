package com.example.sd.learningproject.service.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

/**
 * 利用IntentService实现Service--会自动调用Service的onDestroy
 */
public class IntentServiceActivity extends AppCompatActivity {
    @BindView(R.id.button1)
    Button mButton1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_start);
        ButterKnife.bind(this);

        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(getString(R.string.text_intent_service));
    }

    @OnClick(R.id.button1)
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                // 打印主线程的id
                Log.e("IntentServiceActivity", "Thread id is " + Thread.currentThread().getId());
                Intent intentService = new Intent(this, MyIntentService.class);
                startService(intentService);
                break;
        }
    }
}
