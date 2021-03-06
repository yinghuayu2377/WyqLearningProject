package com.example.sd.learningproject.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

public class BroadcastReceiverStartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver_start);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent(this, NetworkChangeActivity.class);
                startActivity(intent);
                break;

            case R.id.button2:
                Intent intent1 = new Intent(this, MyBroadcastReceiverActivity.class);
                startActivity(intent1);
                break;

            case R.id.button3:
                Intent intent2 = new Intent(this, LocalBroadcastReceiverActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
