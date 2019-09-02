package com.example.sd.learningproject.service.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

/**
 * 异步消息处理机制
 */
public class ThreadActivity extends AppCompatActivity {
    @BindView(R.id.text_view)
    TextView mTextView;
    @BindView(R.id.button)
    Button mButton;

    private Handler mHandler = new Handler(new Handler.Callback() {  // 静态内部类实现，否则可能造成内存泄漏，无法被GC回收
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mTextView.setText("接收到子线程发送的更新通知");
                    break;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_textview_button);
        ButterKnife.bind(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonThread();
            }
        });
    }

    private void sonThread() {
        new Thread(new Runnable() {  // 使用匿名类的方式
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                mHandler.sendMessage(message);
            }
        }).start();
    }
}
