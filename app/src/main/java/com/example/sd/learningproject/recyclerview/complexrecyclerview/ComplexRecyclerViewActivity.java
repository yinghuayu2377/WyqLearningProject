package com.example.sd.learningproject.recyclerview.complexrecyclerview;

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

/**
 * 根据type类型选择使用的ViewHolder
 */
public class ComplexRecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private List<ComplexItem> mDatas = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        ButterKnife.bind(this);
        initFruits();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);  // 指定布局排列方式为横向排列
        mRecyclerView.setLayoutManager(layoutManager);  // 指定布局方式为线性布局
        ComplexAdapter adapter = new ComplexAdapter(mDatas);
        mRecyclerView.setAdapter(adapter);
    }

    private void initFruits() {

        ComplexItem item = new ComplexItem();
        item.setType(1);
        item.setCategory("热点水果");
        mDatas.add(item);

        ComplexItem item1= new ComplexItem();
        item1.setType(2);
        item1.setFruit(new Fruit("西瓜","西瓜有丰富的汁液"));
        mDatas.add(item1);

        ComplexItem item2 = new ComplexItem();
        item2.setType(1);
        item2.setCategory("季节性水果");
        mDatas.add(item2);

        ComplexItem item3= new ComplexItem();
        item3.setType(2);
        item3.setFruit(new Fruit("苹果","苹果有丰富的营养"));
        mDatas.add(item3);

        ComplexItem item4= new ComplexItem();
        item4.setType(2);
        item4.setFruit(new Fruit("桃子","桃子很好吃"));
        mDatas.add(item4);

        ComplexItem item5= new ComplexItem();
        item5.setType(2);
        item5.setFruit(new Fruit("木瓜","木瓜的味道很醇厚"));
        mDatas.add(item5);

        ComplexItem item6= new ComplexItem();
        item6.setType(2);
        item6.setFruit(new Fruit("葡萄","葡萄是酸酸的"));
        mDatas.add(item6);

    }
}
