package com.example.sd.learningproject.recyclerview.nestrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.recyclerview.nestrecyclerview.bean.BookShelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双层RecyclerView嵌套
 */
public class NestRecyclerViewActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private List<BookShelf> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);

        initData();

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        ParentAdapter adapter = new ParentAdapter(mDatas, R.layout.layout_staggered_grid_nest_adapter_item, this);
        mRecyclerView.setAdapter(adapter);
    }

    // 组装数据
    private void initData() {
        mDatas.clear();

        BookShelf bookShelf1 = new BookShelf();
        bookShelf1.setName("科幻类");
        String[] books1 = new String[]{"三体", "流浪地球", "降临"};
        bookShelf1.setBooks(Arrays.asList(books1));
        mDatas.add(bookShelf1);

        BookShelf bookShelf2 = new BookShelf();
        bookShelf2.setName("政治类");
        String[] books2 = new String[]{"美国陷阱", "从赫鲁晓夫到普京", "为什么是以色列", "南京大屠杀"};
        bookShelf2.setBooks(Arrays.asList(books2));
        mDatas.add(bookShelf2);

        BookShelf bookShelf3 = new BookShelf();
        bookShelf3.setName("文学类");
        String[] books3 = new String[]{"我们仨", "小姨多鹤", "我与地坛", "黄金时代", "雪国"};
        bookShelf3.setBooks(Arrays.asList(books3));
        mDatas.add(bookShelf3);

        BookShelf bookShelf4 = new BookShelf();
        bookShelf4.setName("医学类");
        String[] books4 = new String[]{"只有医生知道", "基因传", "癌症传"};
        bookShelf4.setBooks(Arrays.asList(books4));
        mDatas.add(bookShelf4);

        BookShelf bookShelf5 = new BookShelf();
        bookShelf5.setName("财经类");
        String[] books5 = new String[]{"小狗钱钱", "激荡四十年", "巴菲特和他的财富人生"};
        bookShelf5.setBooks(Arrays.asList(books5));
        mDatas.add(bookShelf5);

        BookShelf bookShelf6 = new BookShelf();
        bookShelf6.setName("悬疑类");
        String[] books6 = new String[]{"白夜行", "东方列车谋杀案", "心理罪"};
        bookShelf6.setBooks(Arrays.asList(books6));
        mDatas.add(bookShelf6);

        BookShelf bookShelf7 = new BookShelf();
        bookShelf7.setName("技术类");
        String[] books7 = new String[]{"android进阶之光", "Kotlin实战", "黑客与画家", "程序是怎样跑起来的"};
        bookShelf7.setBooks(Arrays.asList(books7));
        mDatas.add(bookShelf7);
    }
}
