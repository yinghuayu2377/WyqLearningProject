package com.example.sd.learningproject.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.example.sd.learningproject.R;

/**
 * 监听网络变化--动态注册广播接收器
 */
public class NetworkChangeActivity extends AppCompatActivity {
    private NetworkChangeReceiver networkChangeReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");  // 网络状态变化广播
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();  // 获取当前连接可用的网络
            if(networkInfo != null && networkInfo.isConnected()) {  // 已连接网络
                Toast.makeText(context, "network isConnected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "network disconnected", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
