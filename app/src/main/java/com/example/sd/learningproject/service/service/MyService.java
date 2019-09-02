package com.example.sd.learningproject.service.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static String TAG = "MyService";
    private DownloadBinder mBinder = new DownloadBinder();

    public MyService() {

    }

    @Override
    public void onCreate() {  // 在服务第一次创建时调用
        super.onCreate();
        Log.e(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {  // 在每次服务启动的时候调用
        Log.e(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.e(TAG, "startDownload");
        }

        public int getProgress() {
            Log.e(TAG, "getProgress");
            return 0;
        }
    }
}
