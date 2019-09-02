package com.example.sd.learningproject.service.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

public class MyServiceActivity extends AppCompatActivity implements View.OnClickListener {
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
        mButton1.setOnClickListener(this);
        mButton2.setVisibility(View.VISIBLE);
        mButton2.setText(getString(R.string.text_stop));
        mButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, MyService.class);
                stopService(intent2);
                break;
        }
    }
}
