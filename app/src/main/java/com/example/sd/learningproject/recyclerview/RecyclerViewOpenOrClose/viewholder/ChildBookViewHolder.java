package com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.bean.ChildBookItem;

import java.util.List;

public class ChildBookViewHolder extends BaseViewHolder {
    @BindView(R.id.text_book)
    TextView mBookTextView;

    public ChildBookViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindView(List list, Object obj) {
        if(obj instanceof ChildBookItem) {
            mBookTextView.setText(((ChildBookItem) obj).getBookName());
        }
    }
}
