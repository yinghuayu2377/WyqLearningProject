package com.example.sd.learningproject.recyclerview.complexrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.recyclerview.complexrecyclerview.bean.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据type类型选择使用的ViewHolder
 */
public class ComplexRecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private List<ParentItem> mDatas = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        ButterKnife.bind(this);

        getItems();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);  // 指定布局方式为线性布局
        BookAdapter adapter = new BookAdapter(mDatas);
        mRecyclerView.setAdapter(adapter);
    }

    /**
     * 组装item数据
     */
    private void getItems() {
        List<Category> categoryList = initBooks();
        for (int i = 0; i < categoryList.size(); i++) {
            Category category = categoryList.get(i);

            ParentItem item1 = new ParentItem();

            // 组装CategoryItem
            CategoryItem categoryItem = new CategoryItem();
            categoryItem.setCategoryName(category.getName());
            item1.setType(BookAdapter.CATEGORY_ITEM_TYPE);
            item1.setCategoryItem(categoryItem);
            mDatas.add(item1);

            // 组装BookItem
            List<Book> bookList = category.getBooks();
            for (int j = 0; j < bookList.size(); j++) {
                ParentItem item2 = new ParentItem();

                Book book = bookList.get(j);
                BookItem bookItem = new BookItem();
                bookItem.setBookName(book.getName());
                bookItem.setDesc(book.getDesc());

                item2.setType(BookAdapter.BOOK_ITEM_TYPE);
                item2.setBookItem(bookItem);
                mDatas.add(item2);
            }
        }
    }

    /**
     * 组装书籍数据
     */
    private List<Category> initBooks() {
        List<Category> categoryList = new ArrayList<>();

        // 第一个分类
        Category category1 = new Category();
        category1.setName("科幻书");

        List<Book> bookList1 = new ArrayList<>();
        Book book1 = new Book();
        book1.setName("三体");
        book1.setDesc("《三体》是刘慈欣创作的系列长篇科幻小说，由《三体》、《三体Ⅱ·黑暗森林》、《三体Ⅲ·死神永生》组成，" +
                "第一部于2006年5月起在《科幻世界》杂志上连载，第二部于2008年5月首次出版，第三部则于2010年11月出版。");
        bookList1.add(book1);

        Book book2 = new Book();
        book2.setName("太空漫游四部曲");
        book2.setDesc("科幻殿堂的永恒经典， 太空时代的不朽史诗全新修订精装典藏版阿瑟·克拉克，这个时代最伟大的科幻大师和太空预" +
                "言家“太空漫游”系列，世界科幻文学巅峰之作。");
        bookList1.add(book2);
        category1.setBooks(bookList1);
        categoryList.add(category1);

        // 第二个分类
        Category category2 = new Category();
        category2.setName("小说");

        List<Book> bookList2 = new ArrayList<>();
        Book book3 = new Book();
        book3.setName("围城");
        book3.setDesc("围城》是钱钟书所著的长篇小说,是中国现代文学史上一部风格独特的讽刺小说。");
        bookList2.add(book3);

        Book book4 = new Book();
        book4.setName("我与地坛");
        book4.setDesc("《我与地坛》在 2002年5月由人民文学出版社出版发行的图书，作者为史铁生。");
        bookList2.add(book4);

        Book book5 = new Book();
        book5.setName("雪国");
        book5.setDesc("是日本作家川端康成创作的第一部中篇小说，也是他唯美主义代表之作，从1935年起以短篇的形式，分别以《暮景的镜》、《白昼的镜》等题名。");
        bookList2.add(book5);
        category2.setBooks(bookList2);
        categoryList.add(category2);

        // 第三个分类
        Category category3 = new Category();
        category3.setName("技术书");

        List<Book> bookList3 = new ArrayList<>();
        Book book6 = new Book();
        book6.setName("第一行代码");
        book6.setDesc("被Android开发者誉为“Android学习第一书”");
        bookList3.add(book6);
        category3.setBooks(bookList3);
        categoryList.add(category3);
        return categoryList;
    }
}
