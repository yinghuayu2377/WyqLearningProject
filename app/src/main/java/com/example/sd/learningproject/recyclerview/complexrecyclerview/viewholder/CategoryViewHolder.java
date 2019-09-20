package com.example.sd.learningproject.recyclerview.complexrecyclerview.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.recyclerview.complexrecyclerview.bean.CategoryItem;
import com.example.sd.learningproject.recyclerview.complexrecyclerview.bean.ParentItem;

import java.util.List;

public class CategoryViewHolder extends BaseHolder {
    @BindView(R.id.text_view_category_top)
    TextView mTextView;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindView(List list, Object bean) {
        if (bean instanceof ParentItem) {
            CategoryItem item = ((ParentItem) bean).getCategoryItem();
            mTextView.setText(item.getCategoryName());
        }
    }
}
