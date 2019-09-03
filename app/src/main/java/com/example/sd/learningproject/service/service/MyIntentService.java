package com.example.sd.learningproject.service.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {  // 此方法已经在子线程中运行了，不需要新开子线程
        // 打印当前线程的id
        Log.e("MyIntentService", "Thread id is " + Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyIntentService", "onDestroy executed");
    }
}
