package com.example.sd.learningproject.multimedia;

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

public class NotificationStartActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button mButton1;
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.button3)
    Button mButton3;
    @BindView(R.id.button4)
    Button mButton4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_start);
        ButterKnife.bind(this);

        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(getString(R.string.text_button_send_notification));
        mButton2.setVisibility(View.VISIBLE);
        mButton2.setText(getString(R.string.text_choose_picture_and_camera));
        mButton3.setVisibility(View.VISIBLE);
        mButton3.setText(getString(R.string.text_play_audio));
        mButton4.setVisibility(View.VISIBLE);
        mButton4.setText(getString(R.string.text_play_video));
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                gotoActivity(SendNotificationActivity.class);
                break;

            case R.id.button2:
                gotoActivity(CameraAndChoosePhotoActivity.class);
                break;

            case R.id.button3:
                gotoActivity(PlayAudioActivity.class);
                break;

            case R.id.button4:
                gotoActivity(PlayVideoActivity.class);
                break;
        }
    }

    private void gotoActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
