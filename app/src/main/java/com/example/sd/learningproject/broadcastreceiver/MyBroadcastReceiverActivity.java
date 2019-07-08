package com.example.sd.learningproject.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

public class MyBroadcastReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_boradcast_receiver);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent("com.example.sd.MY_BROADCAST");
                intent.setPackage(getPackageName());
                sendBroadcast(intent);  // 发送标准广播
                break;

            case R.id.button2:
                Intent intent1 = new Intent("com.example.sd.MY_BROADCAST");
                intent1.setPackage(getPackageName());
                sendOrderedBroadcast(intent1, null);  // 发送有序广播
                break;
        }
    }
}
