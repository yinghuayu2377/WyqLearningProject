package com.example.sd.learningproject.recyclerview.complexrecyclerview;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.listview.customlistview.Fruit;

import java.util.List;

public class FruitViewHolder extends BaseHolder {

    @BindView(R.id.text_view_name)
    TextView mTextViewName;
    @BindView(R.id.text_view_desc)
    TextView mTextViewDesc;

    public FruitViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    protected void bindView(List source, Object bean) {
        if (bean instanceof ComplexItem) {
            ComplexItem item = (ComplexItem) bean;
            Fruit fruit = item.getFruit();
            mTextViewName.setText(fruit.getName());
            mTextViewDesc.setText(fruit.getDesc());
        }
    }

}