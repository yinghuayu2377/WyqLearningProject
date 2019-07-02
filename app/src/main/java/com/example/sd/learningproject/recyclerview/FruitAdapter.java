package com.example.sd.learningproject.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.listview.customlistview.Fruit;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;
    private int mLayoutId;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        TextView textViewName;
        TextView textViewDesc;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            textViewName = (TextView)view.findViewById(R.id.text_view_name);
            textViewDesc = (TextView)view.findViewById(R.id.text_view_desc);
        }
    }

    public FruitAdapter(List<Fruit> fruitList, int layoutId) {
        mFruitList = fruitList;
        mLayoutId = layoutId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(mLayoutId, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(viewGroup.getContext(), fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.textViewDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(viewGroup.getContext(), fruit.getDesc(), Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Fruit fruit = mFruitList.get(i);
        viewHolder.textViewName.setText(fruit.getName());
        viewHolder.textViewDesc.setText(fruit.getDesc());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
