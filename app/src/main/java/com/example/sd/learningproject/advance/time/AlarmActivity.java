package com.example.sd.learningproject.advance.time;

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

/**
 * Alarm实现定时任务
 */
public class AlarmActivity extends AppCompatActivity {
    @BindView(R.id.button1)
    Button mButton1;
    @BindView(R.id.button2)
    Button mButton2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_start);
        ButterKnife.bind(this);

        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(getString(R.string.text_start));
        mButton2.setVisibility(View.VISIBLE);
        mButton2.setText(getString(R.string.text_stop));
    }

    @OnClick({R.id.button1, R.id.button2})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent(this, LongRunningService.class);
                startService(intent);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, LongRunningService.class);
                stopService(intent2);
                break;
        }
    }
}
