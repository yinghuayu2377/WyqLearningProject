package com.example.sd.learningproject.listview.customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

import java.util.ArrayList;
import java.util.List;


/**
 * 自定义adapter
 */
public class CustomAdapter extends ArrayAdapter<Fruit> {
    @BindView(R.id.text_view_name)
    TextView mTextViewName;
    @BindView(R.id.text_view_desc)
    TextView mTextViewDesc;

    private int mResourceId;
    private List<Fruit> mDatas = new ArrayList<>();

    public CustomAdapter(@NonNull Context context, int resource, List<Fruit> list) {
        super(context, resource, list);
        this.mResourceId = resource;
        this.mDatas = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(mResourceId, parent, false);

        ButterKnife.bind(this, view);
        mTextViewName.setText(fruit.getName());
        mTextViewDesc.setText(fruit.getDesc());
        return view;
    }

    @Nullable
    @Override
    public Fruit getItem(int position) {
        return mDatas.get(position);
    }
}
