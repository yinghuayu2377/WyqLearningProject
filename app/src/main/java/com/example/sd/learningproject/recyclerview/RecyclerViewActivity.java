package com.example.sd.learningproject.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.listview.customlistview.Fruit;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private List<Fruit> mDatas = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        ButterKnife.bind(this);
        initFruits();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);  // 指定布局方式为线性布局
        FruitAdapter adapter = new FruitAdapter(mDatas);
        mRecyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for(int i=0; i< 5; i++) {
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
}
