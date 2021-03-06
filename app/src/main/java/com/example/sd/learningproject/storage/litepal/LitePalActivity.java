package com.example.sd.learningproject.storage.litepal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;
import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;

/**
 * 使用LitePal存储数据
 */
public class LitePalActivity extends AppCompatActivity {

    @BindView(R.id.button7)
    Button mButton7;
    @BindView(R.id.button8)
    Button mButton8;
    @BindView(R.id.button9)
    Button mButton9;
    @BindView(R.id.button10)
    Button mButton10;
    @BindView(R.id.text_view)
    TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        ButterKnife.bind(this);
        mButton7.setVisibility(View.GONE);
        mButton8.setVisibility(View.GONE);
        mButton9.setVisibility(View.GONE);
        mButton10.setVisibility(View.GONE);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:  // 创建数据库
                Connector.getDatabase();
                break;

            case R.id.button2:  // 更新数据库
                Connector.getDatabase();
                break;

            case R.id.button3:  // 添加数据
                Book book = new Book();
                book.setAuthor("mantianxing");
                book.setName("The Love of World");
                book.setPages(124);
                book.setPress("UnKnow");
                book.setPrice((float) 12.98);
                book.save();
                break;

            case R.id.button4:   // 更新数据
                Book book1 = new Book();
                book1.setPress("Anchor");
                book1.setPrice((float) 12.555);
                book1.updateAll("name = ? and author = ?", "The Love of World", "mantianxing");
                break;

            case R.id.button5:  // 删除数据
                LitePal.deleteAll(Book.class, "price > ?", "12");
                break;

            case R.id.button6:  // 查询数据
                List<Book> list = LitePal.findAll(Book.class);
                StringBuilder stringBuilder = new StringBuilder();
                for (Book book2 : list) {
                    stringBuilder.append(book2.getName());
                    stringBuilder.append(book2.getAuthor());
                    stringBuilder.append(book2.getPress());
                    stringBuilder.append(book2.getPrice());
                    stringBuilder.append(book2.getPages());
                }
                mTextView.setText(stringBuilder);
                break;
        }
    }
}
