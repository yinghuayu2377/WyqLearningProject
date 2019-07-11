package com.example.sd.learningproject.storage.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

/**
 * 通过数据库存储数据
 */
public class SqlActivity extends AppCompatActivity {

    @BindView(R.id.text_view)
    TextView mTextView;

    private MyDatabaseHelper databaseHelper = null;
    private MyDatabaseHelper databaseHelperSecond = null;
    private SQLiteDatabase sqLiteDatabase = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        ButterKnife.bind(this);
        databaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        databaseHelperSecond = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        sqLiteDatabase = databaseHelperSecond.getWritableDatabase();
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                databaseHelper.getWritableDatabase();
                break;

            case R.id.button2:
                databaseHelperSecond.getWritableDatabase();
                break;

            case R.id.button3:

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

            case R.id.button4:
                ContentValues contentValues1 = new ContentValues();
                contentValues1.put("price", 17.89);
                sqLiteDatabase.update("Book", contentValues1, "name = ?", new String[]{"The Da Vinci Code"});
                break;

            case R.id.button5:
                sqLiteDatabase.delete("Book", "pages > ?", new String[]{"100"});
                break;

            case R.id.button6:
                Cursor cursor = sqLiteDatabase.query("Book", null, null, null, null, null, null);
                StringBuilder content = new StringBuilder();
                if(cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        float price = cursor.getFloat(cursor.getColumnIndex("price"));
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(name);
                        stringBuilder.append(pages);
                        stringBuilder.append(author);
                        stringBuilder.append(price);
                        stringBuilder.append("\n");
                        content.append(stringBuilder);
                    } while (cursor.moveToNext());
                }
                mTextView.setText(content.toString());
                break;
        }
    }
}
