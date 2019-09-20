package com.example.sd.learningproject.recyclerview.complexrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.recyclerview.complexrecyclerview.bean.ParentItem;
import com.example.sd.learningproject.recyclerview.complexrecyclerview.viewholder.BaseHolder;
import com.example.sd.learningproject.recyclerview.complexrecyclerview.viewholder.BookViewHolder;
import com.example.sd.learningproject.recyclerview.complexrecyclerview.viewholder.CategoryViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据type类型选择使用的ViewHolder
 */
public class BookAdapter extends RecyclerView.Adapter<BaseHolder> {
    private List<ParentItem> mList = new ArrayList<>();
    public static final int CATEGORY_ITEM_TYPE = 1;
    public static final int BOOK_ITEM_TYPE = 2;

    public BookAdapter(List<ParentItem> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public BaseHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {  // i来自getItemViewType的return结果，默认为0，需重写getItemViewType
        switch (i) {
            case CATEGORY_ITEM_TYPE:
                return new CategoryViewHolder(LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.layout_category_view_holder, viewGroup, false));
            case BOOK_ITEM_TYPE:
                return new BookViewHolder(LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.layout_book_view_holder, viewGroup, false));
            default:
                return new BaseHolder(new LinearLayout(viewGroup.getContext())) {
                    @Override
                    public void bindView(List list, Object bean) {

                    }
                };
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseHolder baseHolder, int i) {
        baseHolder.bindView(mList, mList.get(i));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.size() == 0 || position < 0 || position >= mList.size()) {
            return -1;
        }
        ParentItem parentItem = mList.get(position);
        return parentItem.getType();
    }
}
