package com.example.sd.learningproject.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

public class Intent4Activity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent4);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void click(View view) {
        switch (view.getId()) {
            case R.id.button:  // 返回数据给Intent1Activity
                Intent intent = getIntent();
                intent.putExtra("data_return", "这是来自Intent3Activity的问候");
                setResult(RESULT_OK, intent);  // 用于向上一个activity返回数据
                finish();
                break;
        }
    }
}
