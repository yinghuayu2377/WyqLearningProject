package com.example.sd.learningproject.contentProvider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

/**
 * 获取另一个应用传递的数据，这个Activity应该放在其他工程中，放这边是为了方便查看
 */
public class ContentProviderActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button mButton1;
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.button3)
    Button mButton3;
    @BindView(R.id.button4)
    Button mButton4;
    @BindView(R.id.button5)
    Button mButton5;

    String newId = "";
    static String PATH = "content://com.example.sd.learningproject.provider/book";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_start);
        ButterKnife.bind(this);

        mButton1.setText(getString(R.string.text_add_data));
        mButton2.setText(getString(R.string.text_select_data));
        mButton3.setText(getString(R.string.text_update_data));
        mButton4.setText(getString(R.string.text_delete_data));
        mButton5.setVisibility(View.GONE);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:  // 添加数据
                Uri uri = Uri.parse(PATH);
                ContentValues values = new ContentValues();
                values.put("name", "mantianxing3");
                values.put("author", "mantianxing3");
                values.put("pages", 1304);
                values.put("price", 22.3);
                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
                Log.e("provider", newId);
                break;

            case R.id.button2:  // 查询数据
                Uri uri1 = Uri.parse(PATH);
                Cursor cursor = getContentResolver().query(uri1, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        Log.e("provider", "name:" + name);
                    }
                }
                cursor.close();
                break;

            case R.id.button3:  // 更新数据
                Uri uri2 = Uri.parse(PATH + "/" + newId);
                ContentValues values2 = new ContentValues();
                values2.put("name", "mantianxing4");
                getContentResolver().update(uri2, values2, null, null);
                break;

            case R.id.button4:  // 删除数据
                Uri uri3 = Uri.parse(PATH + "/" + newId);
                getContentResolver().delete(uri3, null, null);
                break;
        }
    }
}
