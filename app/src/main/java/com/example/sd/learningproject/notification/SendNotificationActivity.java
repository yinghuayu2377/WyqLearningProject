package com.example.sd.learningproject.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

/**
 * 发送广播
 */
public class SendNotificationActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button mButton1;

    private static String CHANNEL_ID = "test";
    private static String CHANNEL_NAME = "name";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_start);
        ButterKnife.bind(this);

        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(getString(R.string.text_button_send_notification));
    }

    @OnClick({R.id.button1})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                createNotificationChannel(CHANNEL_ID, CHANNEL_NAME);
                Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setContentTitle("This is notification title")
                        .setContentText("This is notification text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .build();
                manager.notify(1, notification);
                break;
        }
    }

    /**
     * 8.0及以上需要创建创建通知渠道
     */
    private void createNotificationChannel(String channelId, String channelName) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {  // 26以上需要添加通知渠道
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channelName);
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
        }
    }
}
