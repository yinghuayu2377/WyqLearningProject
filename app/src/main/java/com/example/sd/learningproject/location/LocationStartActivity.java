package com.example.sd.learningproject.location;

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
import com.example.sd.learningproject.advance.extra.ParcelableActivity;
import com.example.sd.learningproject.advance.extra.ParcelablePerson;
import com.example.sd.learningproject.advance.extra.Person;
import com.example.sd.learningproject.advance.extra.SerializableActivity;

public class LocationStartActivity extends AppCompatActivity {
    @BindView(R.id.button1)
    Button mButton1;
    @BindView(R.id.button2)
    Button mButton2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_start);
        ButterKnife.bind(this);

        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(getString(R.string.text_location));
        mButton2.setVisibility(View.VISIBLE);
        mButton2.setText(getString(R.string.text_baidu_map));
    }

    @OnClick({R.id.button1, R.id.button2})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                gotoActivity(LocationActivity.class);
                break;

            case R.id.button2:
                gotoActivity(BaiduMapActivity.class);
                break;
        }
    }

    private void gotoActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}