package com.example.sd.learningproject.recyclerview.complexrecyclerview.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.recyclerview.complexrecyclerview.bean.BookItem;
import com.example.sd.learningproject.recyclerview.complexrecyclerview.bean.ParentItem;

import java.util.List;

public class BookViewHolder extends BaseHolder {
    @BindView(R.id.text_view_name)
    TextView mTextViewName;
    @BindView(R.id.text_view_desc)
    TextView mTextViewDesc;

    public BookViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindView(List list, Object bean) {
        if (bean instanceof ParentItem) {
            BookItem bookItem = ((ParentItem) bean).getBookItem();
            mTextViewName.setText(bookItem.getBookName());
            mTextViewDesc.setText(bookItem.getDesc());
        }
    }
}