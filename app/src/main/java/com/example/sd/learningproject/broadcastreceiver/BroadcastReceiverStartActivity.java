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

    @OnClick({R.id.button1})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent(this, NetworkChangeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
