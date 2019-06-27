package com.example.sd.learningproject.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

public class Intent2Activity extends AppCompatActivity {
    @BindView(R.id.text_view)
    TextView mTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        if(data != null && data.trim().length() != 0) {
            mTextView.setText(data);
        }
    }
}