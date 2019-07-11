package com.example.sd.learningproject.storage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.storage.sql.SqlActivity;

public class StorageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_start);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent(this, FileSaveActivity.class);
                startActivity(intent);
                break;

            case R.id.button2:
                Intent intent1 = new Intent(this, SharedPreferenceActivity.class);
                startActivity(intent1);
                break;

            case R.id.button3:
                Intent intent2 = new Intent(this, SqlActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
