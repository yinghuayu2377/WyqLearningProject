package com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.bean.ChildBookItem;
import com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.bean.ParentCategoryItem;
import com.example.sd.learningproject.recyclerview.nestrecyclerview.bean.BookShelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单层RecyclerView实现点击展开、折叠item
 */
public class RecyclerViewOpenOrCloseActivity extends AppCompatActivity implements ClickCategoryListener {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private List<BookShelf> mDatas = new ArrayList<>();  // 数据源
    private List<Object> mList = new ArrayList<>();  // item组装数据
    private int mSelectedPosition;  // 当前点击的position
    private BookShelfAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mList.addAll(initItem());
        mAdapter= new BookShelfAdapter(mList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    // 获取数据源
    private List<BookShelf> initData() {

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

        return mDatas;
    }

    // 组装item
    private List<ParentCategoryItem> initItem() {
        List<BookShelf> bookShelves = initData();
        List<ParentCategoryItem> items = new ArrayList<>();
        for (int i = 0; i < bookShelves.size(); i++) {
            BookShelf bookShelf = bookShelves.get(i);

            ParentCategoryItem categoryItem = new ParentCategoryItem();
            categoryItem.setIndex(i);
            categoryItem.setShow(false);
            categoryItem.setCategoryName(bookShelf.getName());
            categoryItem.setChildBookItems(new ArrayList<ChildBookItem>());
            items.add(categoryItem);
        }
        return items;
    }

    // 展开子item
    private void addChildItems(int index) {
        List<String> bookList = mDatas.get(index).getBooks();
        List<ChildBookItem> childBookItems = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            ChildBookItem item = new ChildBookItem();
            item.setBookName(bookList.get(i));
            childBookItems.add(item);
        }
        mList.addAll(mSelectedPosition + 1, childBookItems);  // 添加子item
        ParentCategoryItem categoryItem = (ParentCategoryItem) mList.get(mSelectedPosition);
        categoryItem.setChildBookItems(childBookItems);
        mAdapter.notifyDataSetChanged();
    }

    // 关闭子item
    private void removeChildItems() {
        ParentCategoryItem item = (ParentCategoryItem)mList.get(mSelectedPosition);
        mList.removeAll(item.getChildBookItems());
        item.setChildBookItems(new ArrayList<ChildBookItem>());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void click(int index, int position, boolean isShow) {  // index为此条数据在List<BookShelf>中的位置
        mSelectedPosition = position;
        if(isShow) {
            removeChildItems();
        } else {
            addChildItems(index);
        }
    }
}