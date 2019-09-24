package com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.bean.ChildBookItem;
import com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.bean.ParentCategoryItem;
import com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.viewholder.BaseViewHolder;
import com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.viewholder.ChildBookViewHolder;
import com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.viewholder.ParentCategoryViewHolder;

import java.util.List;

public class BookShelfAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List mDatas;  // 包含ParentCategoryViewHolder和ChildBookItem
    public ClickCategoryListener mListener;

    private static final int TYPE_CATEGORY = 0;
    private static final int TYPE_BOOK = 1;

    public BookShelfAdapter(List list, ClickCategoryListener listener) {
        mDatas = list;
        mListener = listener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case TYPE_CATEGORY:
                return new ParentCategoryViewHolder(LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.layout_category_item, viewGroup, false), this);
            case TYPE_BOOK:
                return new ChildBookViewHolder(LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.layout_recyclerview_open_or_cancel_item_book, viewGroup, false));
            default:
                return new BaseViewHolder(new LinearLayout(viewGroup.getContext())) {
                    @Override
                    public void bindView(List list, Object obj) {

                    }
                };
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = mDatas.get(position);
        if (obj instanceof ParentCategoryItem) {
            return TYPE_CATEGORY;
        } else if (obj instanceof ChildBookItem) {
            return TYPE_BOOK;
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.bindView(mDatas, mDatas.get(i));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

}
