package com.example.sd.learningproject.storage.sql;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
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
    private MyDatabaseHelper databaseHelperSecond = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        ButterKnife.bind(this);
        databaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        databaseHelperSecond = new MyDatabaseHelper(this, "BookStore.db", null ,2);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                databaseHelper.getWritableDatabase();
                break;

            case R.id.button2:
                databaseHelperSecond.getWritableDatabase();
                break;

            case R.id.button3:
                SQLiteDatabase sqLiteDatabase = databaseHelperSecond.getWritableDatabase();
                ContentValues contentValues = new ContentValues();

                // 插入第一条数据
                contentValues.put("name", "The Da Vinci Code");
                contentValues.put("author", "Dan Brown");
                contentValues.put("pages", 23);
                contentValues.put("price", 12.67);
                sqLiteDatabase.insert("Book", null, contentValues);

                // 插入第二条数据
                contentValues.clear();
                contentValues.put("name", "The Da Vinci Code 2");
                contentValues.put("author", "Dan Brown 2");
                contentValues.put("pages", 232);
                contentValues.put("price", 12.672);
                sqLiteDatabase.insert("Book", null, contentValues);
                break;
        }
    }
}
