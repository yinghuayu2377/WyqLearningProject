package com.example.sd.learningproject.listview.customlistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

import java.util.ArrayList;
import java.util.List;

public class CustomListActivity extends AppCompatActivity {

    @BindView(R.id.list_view)
    ListView mListView;

    private List<Fruit> mDatas = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_list_view);

        ButterKnife.bind(this);

        initFruits();
        final CustomAdapter adapter = new CustomAdapter(this, R.layout.layout_custom_adapter_item, mDatas);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomListActivity.this, adapter.getItem(position).getDesc(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        Fruit fruit = new Fruit("苹果","苹果有丰富的营养");
        mDatas.add(fruit);

        Fruit fruit1 = new Fruit("桃子","桃子很好吃");
        mDatas.add(fruit1);

        Fruit fruit2 = new Fruit("西瓜","西瓜有丰富的汁液");
        mDatas.add(fruit2);

        Fruit fruit3 = new Fruit("榴莲","榴莲是水果之王");
        mDatas.add(fruit3);

        Fruit fruit4 = new Fruit("木瓜","木瓜的味道很醇厚");
        mDatas.add(fruit4);

        Fruit fruit5 = new Fruit("葡萄","葡萄是酸酸的");
        mDatas.add(fruit5);

    }
}
