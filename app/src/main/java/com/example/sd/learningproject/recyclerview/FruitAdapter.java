package com.example.sd.learningproject.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.listview.customlistview.Fruit;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewDesc;

        public ViewHolder(View view) {
            super(view);
            textViewName = (TextView)view.findViewById(R.id.text_view_name);
            textViewDesc = (TextView)view.findViewById(R.id.text_view_desc);
        }
    }

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_custom_adapter_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
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
