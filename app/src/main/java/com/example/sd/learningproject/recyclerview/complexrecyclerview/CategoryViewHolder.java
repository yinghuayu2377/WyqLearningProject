package com.example.sd.learningproject.recyclerview.complexrecyclerview;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

import java.util.List;

public class CategoryViewHolder extends BaseHolder {

    @BindView(R.id.text_view_category_top)
    TextView mTextViewCategoryTop;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    protected void bindView(List source, Object bean) {
        if (bean instanceof ComplexItem) {
            ComplexItem item = (ComplexItem) bean;
            mTextViewCategoryTop.setText(item.getCategory());
        }
    }

}
