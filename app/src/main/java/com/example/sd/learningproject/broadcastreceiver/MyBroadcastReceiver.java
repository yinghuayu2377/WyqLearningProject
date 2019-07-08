package com.example.sd.learningproject.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "MyBroadcastreceiver", Toast.LENGTH_SHORT).show();
//        abortBroadcast();  // 截取广播，使后面的广播接收器不再接收到此广播
    }
}
