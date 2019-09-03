package com.example.sd.learningproject.materialdesign.swiperefreshlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.listview.customlistview.Fruit;
import com.example.sd.learningproject.recyclerview.FruitAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现下拉刷新
 */
public class SwipeRefreshLayoutActivity extends AppCompatActivity {
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private List<Fruit> mDatas = new ArrayList<>();
    private FruitAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);
        ButterKnife.bind(this);

        initFruits();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);  // 指定布局排列方式为横向排列
        mRecyclerView.setLayoutManager(layoutManager);  // 指定布局方式为线性布局
        adapter = new FruitAdapter(mDatas, R.layout.layout_custom_adapter_item);
        mRecyclerView.setAdapter(adapter);

        mSwipeRefresh.setColorSchemeResources(R.color.colorPrimary);  // 设置刷新进度条
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {  // 下拉事件
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });
    }

    private void refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruits();
                        adapter.notifyDataSetChanged();
                        mSwipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initFruits() {
        for (int i = 0; i < 5; i++) {
            Fruit fruit = new Fruit("苹果", "苹果有丰富的营养");
            mDatas.add(fruit);

            Fruit fruit1 = new Fruit("桃子", "桃子很好吃");
            mDatas.add(fruit1);

            Fruit fruit2 = new Fruit("西瓜", "西瓜有丰富的汁液");
            mDatas.add(fruit2);

            Fruit fruit3 = new Fruit("榴莲", "榴莲是水果之王");
            mDatas.add(fruit3);

            Fruit fruit4 = new Fruit("木瓜", "木瓜的味道很醇厚");
            mDatas.add(fruit4);

            Fruit fruit5 = new Fruit("葡萄", "葡萄是酸酸的");
            mDatas.add(fruit5);
        }
    }
}
