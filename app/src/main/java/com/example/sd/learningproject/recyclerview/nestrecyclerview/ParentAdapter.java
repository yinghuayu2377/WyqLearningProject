package com.example.sd.learningproject.recyclerview.nestrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.recyclerview.nestrecyclerview.bean.BookShelf;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> {

    private List<BookShelf> mDatas;
    private int mLayoutId;
    private Context mContext;

    public ParentAdapter(List<BookShelf> bookList, int layoutId, Context context) {
        mDatas = bookList;
        mLayoutId = layoutId;
        mContext = context;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(mLayoutId, viewGroup, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder viewHolder, int i) {
        BookShelf bookShelf = mDatas.get(i);
        viewHolder.textView.setText(bookShelf.getName());

        // 子RecyclerView
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        viewHolder.recyclerView.setLayoutManager(manager);
        viewHolder.recyclerView.setAdapter(new ChildAdapter(bookShelf.getBooks(), R.layout.layout_item_book));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ParentViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView recyclerView;

        public ParentViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.text_view);
            recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_parent);
        }
    }

}
