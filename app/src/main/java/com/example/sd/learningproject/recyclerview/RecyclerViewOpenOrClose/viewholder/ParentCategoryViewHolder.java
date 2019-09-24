package com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.viewholder;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.BookShelfAdapter;
import com.example.sd.learningproject.recyclerview.RecyclerViewOpenOrClose.bean.ParentCategoryItem;

import java.util.List;

public class ParentCategoryViewHolder extends BaseViewHolder {
    @BindView(R.id.text_view)
    TextView mTextView;
    @BindView(R.id.image_view)
    ImageView mImageView;

    private BookShelfAdapter mAdapter;
    private View mView;

    public ParentCategoryViewHolder(@NonNull View itemView, BookShelfAdapter adapter) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mView = itemView;
        mAdapter = adapter;
    }

    @Override
    public void bindView(final List list, Object obj) {
        Log.e("TAG","111");
        if (obj instanceof ParentCategoryItem) {
            final ParentCategoryItem categoryItem = (ParentCategoryItem) obj;
            Log.e("TAG",categoryItem.getCategoryName());
            mTextView.setText(categoryItem.getCategoryName());
            Log.e("TAG",categoryItem.getCategoryName());
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAdapter.mListener.click(categoryItem.getIndex(), getAdapterPosition(), categoryItem.isShow());
                    if(categoryItem.isShow()) {
                        mImageView.setImageResource(R.drawable.ic_down);
                    } else {
                        mImageView.setImageResource(R.drawable.ic_up);
                    }
                    categoryItem.setShow(!categoryItem.isShow());
                }
            });
        }
    }
}
