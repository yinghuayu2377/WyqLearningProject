package com.example.sd.learningproject.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

public class NormalListViewActivity extends AppCompatActivity {

    @BindView(R.id.list_view)
    ListView mListView;

    private String[] mData = {"苹果", "香蕉", "橘子", "菠萝", "梨子", "凤梨", "番茄", "西瓜", "桃子", "葡萄", "哈密瓜", "火龙果", "榴莲", "柠檬", "百香果"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_list_view);

        ButterKnife.bind(this);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mData);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(NormalListViewActivity.this, adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
