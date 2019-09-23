package com.example.sd.learningproject.recyclerview.nestrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.sd.learningproject.R;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {
    private List<String> mBooks;
    private int mLayoutId;

    public ChildAdapter(List<String> list, int layoutId) {
        mBooks = list;
        mLayoutId = layoutId;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(mLayoutId, viewGroup, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder childViewHolder, int i) {
        childViewHolder.textView.setText(mBooks.get(i));
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    static class ChildViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ChildViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.text_book);
        }
    }
}
