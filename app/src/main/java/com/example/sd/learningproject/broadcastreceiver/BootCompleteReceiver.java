package com.example.sd.learningproject.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 实现开机启动--静态注册广播接收器
 */
public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {  // onReceive中不允许开启线程
        Toast.makeText(context, "开机启动WyqLearningProject", Toast.LENGTH_SHORT).show();
    }
}
