package com.example.sd.learningproject.multimedia;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.VideoView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

import java.io.File;

public class PlayVideoActivity extends AppCompatActivity {
    @BindView(R.id.video_view)
    VideoView mVideoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        ButterKnife.bind(this);

        // 首先检查权限，这里省略
        File file = new File(Environment.getExternalStorageDirectory(), "S01E01.mkv");
        mVideoView.setVideoPath(file.getPath());
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3})
    void opt(View view) {
        switch (view.getId()) {
            case R.id.button1:  // 播放
                if(!mVideoView.isPlaying()) {
                    mVideoView.start();
                }
                break;

            case R.id.button2:  // 暂停
                if(mVideoView.isPlaying()) {
                    mVideoView.pause();
                }
                break;

            case R.id.button3:  // 重新播放
                if(mVideoView.isPlaying()) {
                    mVideoView.resume();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mVideoView != null) {
            mVideoView.suspend();
        }
    }
}
