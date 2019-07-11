package com.example.sd.learningproject.storage.sql;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

/**
 * 通过数据库存储数据
 */
public class SqlActivity extends AppCompatActivity {
    private MyDatabaseHelper databaseHelper = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        ButterKnife.bind(this);
        databaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
    }

    @OnClick({R.id.button1})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                databaseHelper.getWritableDatabase();
                break;
        }
    }
}
