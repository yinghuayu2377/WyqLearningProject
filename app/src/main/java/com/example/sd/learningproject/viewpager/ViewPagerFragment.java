package com.example.sd.learningproject.viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

public class ViewPagerFragment extends Fragment {

    @BindView(R.id.button1)
    Button mButton;

    private int mType = 1;

    public static ViewPagerFragment newInstance(int type) {
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        viewPagerFragment.setArguments(bundle);
        return viewPagerFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if(bundle != null) {
            mType = bundle.getInt("type");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_normal_start, container, false);
        ButterKnife.bind(this, view);

        mButton.setVisibility(View.VISIBLE);
        initView();
        return view;
    }

    private void initView() {
        switch (mType) {
            case 1:
                mButton.setText("这是第一个页面");
                break;
            case 2:
                mButton.setText("这是第二个页面");
                break;
            case 3:
                mButton.setText("这是第三个页面");
                break;
        }
    }
}
