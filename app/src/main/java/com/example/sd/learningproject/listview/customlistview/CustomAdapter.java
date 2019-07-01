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
        View view;
        ViewHolder viewHolder;

        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(mResourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textViewName = (TextView)view.findViewById(R.id.text_view_name);
            viewHolder.textViewDesc = (TextView)view.findViewById(R.id.text_view_desc);
            view.setTag(viewHolder);  // 将ViewHolder存储在view中
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();  // 重新获取ViewHolder
        }
        viewHolder.textViewName.setText(fruit.getName());
        viewHolder.textViewDesc.setText(fruit.getDesc());
        return view;
    }

    @Nullable
    @Override
    public Fruit getItem(int position) {
        return mDatas.get(position);
    }

    class ViewHolder {
        TextView textViewName;
        TextView textViewDesc;
    }
}
