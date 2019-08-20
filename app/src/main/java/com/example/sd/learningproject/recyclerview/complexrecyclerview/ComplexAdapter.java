package com.example.sd.learningproject.recyclerview.complexrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.sd.learningproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据type类型选择使用的ViewHolder
 */
public class ComplexAdapter extends RecyclerView.Adapter<BaseHolder> {
    private List<ComplexItem> mItemList = new ArrayList<>();

    public ComplexAdapter(List<ComplexItem> complexItems) {
        mItemList = complexItems;
    }

    @NonNull
    @Override
    public BaseHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
                return new CategoryViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(R.layout.layout_item_view_category_top, viewGroup, false));
            case 2:
                return new FruitViewHolder(LayoutInflater.from(viewGroup.getContext()).
                        inflate(R.layout.layout_custom_adapter_item, viewGroup, false));
            default:
                return new BaseHolder(new LinearLayout(viewGroup.getContext())) {
                    @Override
                    protected void bindView(List source, Object bean) {

                    }
                };
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseHolder baseHolder, int i) {  // i来自于getItemViewType的返回值，不重写getItemViewType()的话，i始终为0
        baseHolder.bindView(mItemList, mItemList.get(i));
    }

    @Override
    public int getItemViewType(int position) {
        return getMyItemViewType(position);
    }

    private int getMyItemViewType(int position) {
        if (mItemList.size() == 0 || position < 0 || position >= mItemList.size()) {
            return -1;
        }
        ComplexItem item = mItemList.get(position);
        return item.getType();
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
