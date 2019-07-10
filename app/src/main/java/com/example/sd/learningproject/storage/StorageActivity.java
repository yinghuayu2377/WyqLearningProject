package com.example.sd.learningproject.storage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

public class StorageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_start);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent(this, FileSaveActivity.class);
                startActivity(intent);
                break;
        }
    }
}
