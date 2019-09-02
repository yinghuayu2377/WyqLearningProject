package com.example.sd.learningproject.service.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
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
    @BindView(R.id.button3)
    Button mButton3;
    @BindView(R.id.button4)
    Button mButton4;

    private MyService.DownloadBinder mDownloadBinder;

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
        mButton3.setVisibility(View.VISIBLE);
        mButton3.setText(getString(R.string.text_bind_service));
        mButton3.setOnClickListener(this);
        mButton4.setVisibility(View.VISIBLE);
        mButton4.setText(getString(R.string.text_unbind_service));
        mButton4.setOnClickListener(this);
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
            case R.id.button3:
                Intent intent3 = new Intent(this, MyService.class);  // 绑定service
                bindService(intent3, connection, BIND_AUTO_CREATE);
                break;
            case R.id.button4:
                unbindService(connection);  // 解绑service
                break;
        }
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownloadBinder = (MyService.DownloadBinder) service;
            mDownloadBinder.startDownload();  // 调用DownloadBinder的方法
            mDownloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
